package com.yanghaijia.controller;

import com.alibaba.fastjson.JSON;
import com.yanghaijia.domain.Department;
import com.yanghaijia.domain.Password;
import com.yanghaijia.domain.Patients;
import com.yanghaijia.domain.Staff;
import com.yanghaijia.service.DepartmentService;
import com.yanghaijia.service.PasswordService;
import com.yanghaijia.service.PatientsService;
import com.yanghaijia.service.StaffService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.yanghaijia.controller.ConstantForController.*;

/**
 * @author yanghaijia
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private PatientsService patientsService;
    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("home")
    public String gotoDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            if (Objects.equals(c.getName(), "alreadyLogin")) {
                switch (c.getValue()) {
                    case "asDoctor":
                        response.sendRedirect(request.getContextPath() + "/doctor");
                        break;
                    case "asAdmin":
                        response.sendRedirect(request.getContextPath() + "/admin");
                        break;
                    case "Patient":
                        response.sendRedirect(request.getContextPath() + "/user");
                        break;
                    default:
                        return "Login";
                }
            }
        }
        return "Login";
    }


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String doLogin(String id, String password, String role, HttpServletRequest request, Model model, HttpServletResponse response, String savecookie) throws IOException {

        if (id == null || id.trim().length() == 0 || password == null || password.trim().length() == 0 || role == null || role.trim().length() == 0) {
//           errorNavigator(model,INCOMPLETE_FORM);
            String json = JSON.toJSONString(INCOMPLETE_FORM);
            model.addAttribute("error", json);
            return "Error";
        }
        if (role.equals(TEXT_ZERO)) {
            Staff s = staffService.fetchOne(id);
            if (s == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            } else if ("Admin".equals(s.getWorkerRole())) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        } else if (role.equals(TEXT_ONE)) {
            Patients p = patientsService.fetchOne(id);
            if (p == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            }
        } else if (role.equals(TEXT_TWO)) {
            if (!staffService.isAdmin(id)) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        }

        if (TEXT_ZERO.equals(role)) {
            //TODO 做一个数据库的查询，判断到你的数据库有没有这个账号 表单验证之类的

            if (CHECK_BOX_CHECKED.equals(savecookie)) {
                Cookie c = new Cookie("alreadyLogin", "asDoctor");
                c.setMaxAge(10000);
                response.addCookie(c);
            }
            response.sendRedirect(request.getContextPath() + "/doctor");
        } else if (TEXT_ONE.equals(role)) {
            //TODO 做一个数据库的查询，判断到你的数据库有没有这个账号 表单验证之类的
            if (CHECK_BOX_CHECKED.equals(savecookie)) {
                Cookie c = new Cookie("alreadyLogin", "asUser");
                c.setMaxAge(10000);
                response.addCookie(c);
            }
            response.sendRedirect(request.getContextPath() + "/user");
        } else if (TEXT_TWO.equals(role)) {
            String passwordHash = new Md5Hash(password, null, 2).toString();
//            System.out.println("note1:"+passwordHash);
            Password ps = passwordService.fetchOne(id);
//            System.out.println("note2:"+JSON.toJSONString(ps));
            if (ps == null) {
                String error = JSON.toJSONString(NO_SUCH_USER);
                model.addAttribute("error", error);
                return "Error";
            } else if (!Objects.equals(ps.getPasswordHash(), passwordHash)) {
                String error = JSON.toJSONString(VERIFICATION_FAIL);
                model.addAttribute("error", error);
                return "Error";
            }
            if (CHECK_BOX_CHECKED.equals(savecookie)) {
                Cookie c = new Cookie("alreadyLogin", "asAdmin");
                Cookie c2 = new Cookie("name", staffService.fetchOne(ps.getUserId()).getWorkerName());
                c.setMaxAge(10000);
                c2.setMaxAge(10000);
                response.addCookie(c);
                response.addCookie(c2);
            }
            HttpSession s = request.getSession();
            s.setAttribute("alreadyLogin", "asAdmin");
            s.setAttribute("name", staffService.fetchOne(ps.getUserId()).getWorkerName());
            response.sendRedirect(request.getContextPath() + "/admin");
        }
        return null;

    }

    @RequestMapping(value = "/about")
    public String about() {

        return "About";

    }

    @RequestMapping("/admin")
    public String admin(Model m, HttpServletRequest request) {
        Cookie[] allcookie = request.getCookies();
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("whoareyou") != null) {
            m.addAttribute("userName", httpSession.getAttribute("whoareyou"));
        }
        else {
            for (Cookie c : allcookie) {
                if ("name".equals(c.getName())) {
                    m.addAttribute("userName", c.getValue());
                }
            }
        }
        List<Department> dps=departmentService.fetchAll();
        m.addAttribute("alldepart",dps);

        String[] s=new String[]{"序号","唯一编号","姓名","所属科室","联系方式","邮箱","其他说明","操作"};
        List<Staff> allStaff=staffService.selectSome(0,15);
        List<Department> allDepart=departmentService.fetchAll();
        m.addAttribute("head",s);
        m.addAttribute("allstaff",allStaff);
        return "Admin";
    }

    @RequestMapping("/doctor")
    public String doctor(Model m, HttpServletResponse response, HttpServletRequest request) {
        Cookie[] allcookie = request.getCookies();
        HttpSession httpSession = request.getSession();

        if (httpSession.getAttribute("whoareyou") != null) {
            m.addAttribute("userName", httpSession.getAttribute("whoareyou"));
        }
        else {
            for (Cookie c : allcookie) {
                if ("name".equals(c.getName())) {
                    m.addAttribute("userName", c.getValue());
                }
            }
        }

        return "Doctor";
    }

//安全退出，把cookie和session都给抹了
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        s.removeAttribute("userName");
        s.removeAttribute("alreadyLogin");
        Cookie c1=new Cookie("name",null);
        c1.setMaxAge(0);
//        c1.setPath("/");
       Cookie c2=new Cookie("alreadyLogin",null);
//       c2.setPath("/");
       c2.setMaxAge(0);
       response.addCookie(c1);
       response.addCookie(c2);
       response.sendRedirect(request.getContextPath());
    }
}