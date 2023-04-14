package com.yanghaijia.service.impl;

import com.alibaba.fastjson2.JSON;
import com.yanghaijia.dao.DepartmentService;
import com.yanghaijia.dao.PatientsService;
import com.yanghaijia.dao.StaffService;
import com.yanghaijia.domain.Department;
import com.yanghaijia.domain.Patients;
import com.yanghaijia.domain.Staff;
import com.yanghaijia.frame.Role;
import com.yanghaijia.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

import static com.yanghaijia.controller.ConstantForController.*;
import static com.yanghaijia.controller.ConstantForController.CHECK_BOX_CHECKED;

/**
 * 说明:
 *
 * @author haijiay
 * 创建时间: 2023/4/14 11:45
 */


public class BaseServiceImpl implements BaseService {

    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PatientsService patientsService;

    @Override
    public String gotoDoctor(HttpServletRequest request, HttpServletResponse response, Model model) {
        Cookie[] cookies = request.getCookies();
        try {
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
        } catch (Exception e) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                e.printStackTrace(new PrintWriter(baos));
                model.addAttribute("error", baos.toString());
            } catch (Exception ioe) {
                model.addAttribute("error", ioe.toString());
            }
            return "Error";
        }

    }

    @Override
    public String doLogin(String id, String password, String role, HttpServletRequest request, Model model, HttpServletResponse response, String savecookie) {

        if (StringUtils.isBlank(id) || StringUtils.isBlank(password) || StringUtils.isEmpty(role)) {
//           errorNavigator(model,INCOMPLETE_FORM);
            String json = JSON.toJSONString(INCOMPLETE_FORM);
            model.addAttribute("error", json);
            return "Error";
        }
        if (Role.DOCTOR.getValue().equals(role)) {
            Staff s = staffService.lambdaQuery().eq(Staff::getWorkerId, id).one();
            if (s == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            } else if ("Admin".equals(s.getWorkerRole())) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        } else if (Role.PATIENTS.getValue().equals(role)) {
            Patients p = patientsService.lambdaQuery().eq(Patients::getPId, id).one();
            if (p == null) {
                model.addAttribute("error", JSON.toJSONString(NO_SUCH_USER));
                return "Error";
            }
        } else if (Role.ADMIN.getValue().equals(role)) {
            if (staffService.lambdaQuery().eq(Staff::getWorkerId, id).eq(Staff::getWorkerRole, Role.ADMIN.getValue()).count() == 0) {
                model.addAttribute("error", JSON.toJSONString(WRONG_ROLE));
                return "Error";
            }
        }
        try {
            Staff ps = staffService.lambdaQuery().eq(Staff::getWorkerId, id).one();
            switch (role) {
                case "0": {
                    String passwordHash = new Md5Hash(password, null, 2).toString();
                    if (ps == null) {
                        String error = JSON.toJSONString(NO_SUCH_USER);
                        model.addAttribute("error", error);
                        return "Error";
                    } else if (!StringUtils.equals(passwordHash, ps.getWorkerPassword())) {
                        String error = JSON.toJSONString(VERIFICATION_FAIL);
                        model.addAttribute("error", error);
                        return "Error";
                    }
                    if (CHECK_BOX_CHECKED.equals(savecookie)) {
                        Cookie c = new Cookie("alreadyLogin", "asDoctor");
                        Cookie c2 = new Cookie("name", staffService.lambdaQuery().eq(Staff::getWorkerId, id).one().getWorkerName());
                        c.setMaxAge(10000);
                        c2.setMaxAge(10000);
                        response.addCookie(c);
                        response.addCookie(c2);
                        Cookie c3 = new Cookie("id", ps.getWorkerId());
                        c3.setMaxAge(10000);
                        response.addCookie(c3);

                    }
                    HttpSession s = request.getSession();
                    s.setAttribute("alreadyLogin", "asDoctor");
                    s.setAttribute("name", staffService.lambdaQuery().eq(Staff::getWorkerId, id).one().getWorkerName());
                    s.setAttribute("id", ps.getWorkerId());
                    response.sendRedirect(request.getContextPath() + "/doctor");
                    break;
                }
                case "1": {
                    String passwordHash = new Md5Hash(password, null, 2).toString();
                    Patients patient = patientsService.lambdaQuery().eq(Patients::getPId, id).one();
                    if (patient == null) {
                        String error = JSON.toJSONString(NO_SUCH_USER);
                        model.addAttribute("error", error);
                        return "Error";
                    } else if (!Objects.equals(patient.getPPassword(), passwordHash)) {
                        String error = JSON.toJSONString(VERIFICATION_FAIL);
                        model.addAttribute("error", error);
                        return "Error";
                    }
                    if (CHECK_BOX_CHECKED.equals(savecookie)) {
                        Cookie c = new Cookie("alreadyLogin", "asUser");
                        Cookie c2 = new Cookie("name", patient.getPName());
                        c.setMaxAge(10000);
                        c2.setMaxAge(10000);
                        response.addCookie(c);
                        response.addCookie(c2);
                        Cookie c3 = new Cookie("id", patient.getPId());
                        c3.setMaxAge(10000);
                        response.addCookie(c3);
                        c.setMaxAge(10000);
                        response.addCookie(c);
                    }
                    HttpSession s = request.getSession();
                    s.setAttribute("alreadyLogin", "asUser");
                    s.setAttribute("name", patient.getPName());
                    s.setAttribute("id", patient.getPId());
                    response.sendRedirect(request.getContextPath() + "/user");
                    break;
                }
                case "2": {
                    String passwordHash = new Md5Hash(password, null, 2).toString();
                    if (ps == null) {
                        String error = JSON.toJSONString(NO_SUCH_USER);
                        model.addAttribute("error", error);
                        return "Error";
                    } else if (!Objects.equals(ps.getWorkerPassword(), passwordHash)) {
                        String error = JSON.toJSONString(VERIFICATION_FAIL);
                        model.addAttribute("error", error);
                        return "Error";
                    }
                    if (CHECK_BOX_CHECKED.equals(savecookie)) {
                        Cookie c = new Cookie("alreadyLogin", "asAdmin");
                        Cookie c2 = new Cookie("name", ps.getWorkerName());

                        c.setMaxAge(10000);
                        c2.setMaxAge(10000);
                        response.addCookie(c);
                        response.addCookie(c2);
                        Cookie c3 = new Cookie("id", ps.getWorkerId());
                        c3.setMaxAge(10000);
                        response.addCookie(c3);
                    }
                    HttpSession s = request.getSession();
                    s.setAttribute("alreadyLogin", "asAdmin");
                    s.setAttribute("name", ps.getWorkerName());
                    s.setAttribute("id", ps.getWorkerId());
                    response.sendRedirect(request.getContextPath() + "/admin");
                    break;
                }
                default:
                    break;
            }
        } catch (Exception e) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                e.printStackTrace(new PrintWriter(baos));
                model.addAttribute("error", baos.toString());
            } catch (Exception ioe) {
                model.addAttribute("error", ioe.toString());
            }
            return "Error";
        }
        return null;
    }

    @Override
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
        List<Department> dps = departmentService.list();
        m.addAttribute("alldepart", dps);
        String[] s = new String[]{"唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<Staff> allStaff = staffService.list();
//        List<Department> allDepart = departmentService.fetchAll();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Admin";
    }

    @Override
    public String doctor(Model m, HttpServletResponse response, HttpServletRequest request) {
        Cookie[] allcookie = request.getCookies();
        HttpSession httpSession = request.getSession();
        String id = "";
        if (httpSession.getAttribute("whoareyou") != null) {
            m.addAttribute("userName", httpSession.getAttribute("whoareyou"));
        } else {
            for (Cookie c : allcookie) {
                if ("name".equals(c.getName())) {
                    m.addAttribute("userName", c.getValue());
                }
            }
        }
        id = (String) httpSession.getAttribute("id");
        String[] s = new String[]{"唯一编号", "姓名", "联系方式", "邮箱", "其他说明", "操作"};
        Staff staff = staffService.lambdaQuery().eq(Staff::getWorkerId,id).one();
        List<Patients> allStaff = patientsService.lambdaQuery().eq(Patients::getPDepartment,staff.getWorkerDepartment()).list();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Doctor";
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession s = request.getSession();
        s.removeAttribute("userName");
        s.removeAttribute("alreadyLogin");
        Cookie c1 = new Cookie("name", null);
        c1.setMaxAge(0);
        Cookie c2 = new Cookie("alreadyLogin", null);
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String gotoUser() {
        return null;
    }



}
