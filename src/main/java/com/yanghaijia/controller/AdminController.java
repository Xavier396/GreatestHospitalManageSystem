package com.yanghaijia.controller;

import com.yanghaijia.domain.Department;
import com.yanghaijia.domain.Staff;
import com.yanghaijia.service.DepartmentService;
import com.yanghaijia.service.StaffService;
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

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/staffManager")
    public String staffManager(Model m) {
        //表头
        String[] s = new String[]{"序号", "唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<Staff> allStaff = staffService.fetchAll();
        List<Department> allDepart = departmentService.fetchAll();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Admin";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        s.removeAttribute("userName");
        s.removeAttribute("alreadyLogin");
        Cookie c1 = new Cookie("name", null);
        c1.setMaxAge(0);
//        c1.setPath("/");
        Cookie c2 = new Cookie("alreadyLogin", null);
//       c2.setPath("/");
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        response.sendRedirect(request.getContextPath());
    }

    @RequestMapping("/home")
    public void home(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath());
    }
    @RequestMapping("/addstaff")
    public String addStaff(Model m)
    {
        return "AddStaff";
    }

    @RequestMapping("/adduser")
    public String addUser(Model m)
    {
        return "AddUser";
    }

    @RequestMapping("/filter")
    public String filter(Model m, Integer limit ,String depart,String keyword)
    {
        String[] s = new String[]{"序号", "唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<Staff> allStaff=staffService.fetchSome(depart,keyword);
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Admin";
    }

    //todo 添加代码，保存医生和病人

}
