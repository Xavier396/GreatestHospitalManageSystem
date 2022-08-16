package com.yanghaijia.controller;

import com.alibaba.fastjson.JSON;
import com.yanghaijia.domain.*;
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
        if (cookies!=null && cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if ("id".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    StaffN staff = staffService.getById(token);
                    if (staff != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("staff", staff);
                        return "redirect:/doctor/home";
                    }
                }
            }

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
            StaffN s = staffService.lambdaQuery().eq(StaffN::getId,id).one();
            if (s == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            } else if ("Admin".equals(s.getWorkerRole())) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        } else if (role.equals(TEXT_ONE)) {
            PatientsN p = patientsService.lambdaQuery().eq(PatientsN::getId,id).one();
            if (p == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            }
        }
        else if (role.equals(TEXT_TWO)) {
            StaffN s = staffService.lambdaQuery().eq(StaffN::getId,id).one();
            if (!"Admin".equals(s.getWorkerRole())) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        }

        switch (role) {
            case TEXT_ZERO: {
                String passwordHash = new Md5Hash(password, null, 2).toString();
                PasswordN ps = passwordService.lambdaQuery().eq(PasswordN::getId,id).one();
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
                    Cookie c = new Cookie("alreadyLogin", "asDoctor");
                    Cookie c2 = new Cookie("name", staffService.lambdaQuery().eq(StaffN::getId,ps.getUserId()).one().getWorkerName());
                    c.setMaxAge(10000);
                    c2.setMaxAge(10000);
                    response.addCookie(c);
                    response.addCookie(c2);
                    Cookie c3=new Cookie("id",ps.getUserId());
                    c3.setMaxAge(10000);
                    response.addCookie(c3);

                }
                HttpSession s = request.getSession();
                s.setAttribute("alreadyLogin", "asDoctor");
                s.setAttribute("name", staffService.lambdaQuery().eq(StaffN::getId,ps.getUserId()).one().getWorkerName());
                s.setAttribute("id",ps.getUserId());
                response.sendRedirect(request.getContextPath() + "/doctor");
                break;
            }
            case TEXT_ONE: {
                String passwordHash = new Md5Hash(password, null, 2).toString();
                PasswordN ps = passwordService.lambdaQuery().eq(PasswordN::getId,id).one();
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
                    Cookie c = new Cookie("alreadyLogin", "asUser");
                    Cookie c2 = new Cookie("name", patientsService.lambdaQuery().eq(PatientsN::getId,ps.getUserId()).one().getPName());
                    c.setMaxAge(10000);
                    c2.setMaxAge(10000);
                    response.addCookie(c);
                    response.addCookie(c2);
                    Cookie c3=new Cookie("id",ps.getUserId());
                    c3.setMaxAge(10000);
                    response.addCookie(c3);
                    c.setMaxAge(10000);
                    response.addCookie(c);
                }
                HttpSession s = request.getSession();
                s.setAttribute("alreadyLogin", "asUser");
                s.setAttribute("name", patientsService.lambdaQuery().eq(PatientsN::getId,ps.getUserId()).one().getPName());
                s.setAttribute("id",ps.getUserId());
                response.sendRedirect(request.getContextPath() + "/user");
                break;
            }
            case TEXT_TWO: {
                String passwordHash = new Md5Hash(password, null, 2).toString();
                PasswordN ps = passwordService.lambdaQuery().eq(PasswordN::getId,id).one();
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
                    Cookie c2 = new Cookie("name", staffService.lambdaQuery().eq(StaffN::getId,id).one().getWorkerName());

                    c.setMaxAge(10000);
                    c2.setMaxAge(10000);
                    response.addCookie(c);
                    response.addCookie(c2);
                    Cookie c3=new Cookie("id",ps.getUserId());
                    c3.setMaxAge(10000);
                    response.addCookie(c3);
                }
                HttpSession s = request.getSession();
                s.setAttribute("alreadyLogin", "asAdmin");
                s.setAttribute("name", staffService.lambdaQuery().eq(StaffN::getId,id).one().getWorkerName());
                s.setAttribute("id",ps.getUserId());
                response.sendRedirect(request.getContextPath() + "/admin");
                break;
            }
            default:
                HttpSession s = request.getSession();
                s.setAttribute("alreadyLogin", "asAdmin");
                s.setAttribute("name", "TEST");
                s.setAttribute("id","00001");
                response.sendRedirect(request.getContextPath() + "/admin");
                break;
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
        } else {
            for (Cookie c : allcookie) {
                if ("name".equals(c.getName())) {
                    m.addAttribute("userName", c.getValue());
                }
            }
        }
        List<DepartmentN> dps = departmentService.list();
        m.addAttribute("alldepart", dps);
        String[] s = new String[]{"唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<StaffN> allStaff = staffService.list().subList(0,15);
        List<DepartmentN> allDepart = departmentService.list();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Admin";
    }

    @RequestMapping("/doctor")
    public String doctor(Model m, HttpServletResponse response, HttpServletRequest request) {
        Cookie[] allcookie = request.getCookies();
        HttpSession httpSession = request.getSession();
        String id= "";
        if (httpSession.getAttribute("whoareyou") != null) {
            m.addAttribute("userName", httpSession.getAttribute("whoareyou"));
        } else {
            for (Cookie c : allcookie) {
                if ("name".equals(c.getName())) {
                    m.addAttribute("userName", c.getValue());
                }
            }
        }
        id= (String) httpSession.getAttribute("id");
        String[] s = new String[]{"唯一编号", "姓名", "联系方式", "邮箱", "其他说明", "操作"};
        List<StaffN> allStaff = staffService.lambdaQuery().eq(StaffN::getWorkerDepartment,staffService.getById(id).getWorkerDepartment()).list();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Doctor";
    }

    //安全退出，把cookie和session都给抹了
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        s.removeAttribute("userName");
        s.removeAttribute("alreadyLogin");
        Cookie c1 = new Cookie("name", null);
        c1.setMaxAge(0);
        Cookie c2 = new Cookie("alreadyLogin", null);
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        response.sendRedirect(request.getContextPath());
    }

    @RequestMapping("/user")
    public String gotoUser() {

        return "User";
    }
}