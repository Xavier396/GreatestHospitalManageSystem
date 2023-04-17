package com.yanghaijia.controller;

import com.alibaba.fastjson2.JSON;
import com.yanghaijia.dao.DepartmentService;
import com.yanghaijia.dao.PatientsService;
import com.yanghaijia.dao.StaffService;
import com.yanghaijia.domain.Department;
import com.yanghaijia.domain.Patients;
import com.yanghaijia.domain.Staff;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.lang3.RandomStringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.yanghaijia.controller.ConstantForController.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PatientsService patientsService;


    @RequestMapping("/staffManager")
    public String staffManager(Model m) {
        //表头
        String[] s = new String[]{ "唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<Staff> allStaff = staffService.lambdaQuery().list();
        List<Department> allDepart = departmentService.lambdaQuery().list();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        m.addAttribute("alldepart",allDepart);
        return "Admin";
    }

    @RequestMapping("/userManager")
    public String userManager(Model m)
    {
        String [] s=new String[]{ "唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        List<Patients> allPatient=patientsService.lambdaQuery().list();
        List<Department> allDepart = departmentService.lambdaQuery().list();
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allPatient);
        m.addAttribute("alldepart",allDepart);
        return "UserView";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
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

    @RequestMapping("/home")
    public void home(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath());
    }

    @RequestMapping("/addstaff")
    public String addStaff(Model m)
    {
        List<Department> allDepart=departmentService.lambdaQuery().list();
        m.addAttribute("allDepart",allDepart);
        return "AddStaff";
    }

    @RequestMapping("/adduser")
    public String addUser(Model m)
    {
        List<Department> departments=departmentService.lambdaQuery().list();
        m.addAttribute("alldepart",departments);
        return "AddUser";
    }

    @RequestMapping("/filter")
    public String filter(Model m, Integer limit ,String depart,String keyword)
    {
        String[] s = new String[]{"序号", "唯一编号", "姓名", "所属科室", "联系方式", "邮箱", "其他说明", "操作"};
        //FIXME:重写
        List<Staff> allStaff=new ArrayList<>();
//                staffService.fetchSome(depart,keyword);
        m.addAttribute("head", s);
        m.addAttribute("allstaff", allStaff);
        return "Admin";
    }

    @RequestMapping("/removedoctor/{id}")
    public void  removeDoctor(@PathVariable String id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        staffService.removeById(id);
        response.sendRedirect(request.getContextPath()+"/admin");
    }

    @RequestMapping("/removeuser/{id}")
    public void removeUser(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        patientsService.removeById(id);
//                .lambdaQuery().eq(Patients::getPId,id);
        response.sendRedirect(request.getContextPath()+"/admin");
    }

    @RequestMapping("/savestaff")
    public String  saveStaff(Model m,String worker_name,String worker_birthday,String worker_phone,String worker_email,String worker_department,String worker_other_note ,HttpServletResponse response,HttpServletRequest request) throws IOException {
        if (worker_phone.trim().length()==0||worker_phone==null||worker_name.trim().length()==0||worker_name==null||worker_birthday.trim().length()==0||worker_birthday==null||worker_email.trim().length()==0||worker_email==null||worker_department.trim().length()==0||worker_department==null)
        {
            m.addAttribute("error", JSON.toJSONString(INCOMPLETE_FORM));
            return "Error";
        }
        Staff staff=new Staff();
        staff.setWorkerId("B"+RandomStringUtils.random(6,true,true));
        staff.setWorkerRole("Doctor");
        staff.setWorkerName(worker_name);
        staff.setWorkerBirthday(worker_birthday);
        staff.setWorkerPhone(worker_phone);
        staff.setWorkerEmail(worker_email);
        staff.setWorkerDepartment(worker_department);
        staff.setWorkerOtherNote(worker_other_note);
//        staffService.insertOne(staff);
//        Password password=new Password();
//        password.setUserId(staff.getWorkerId());
//        password.setUserPhone(staff.getWorkerPhone());
//        password.setPasswordHash(new Md5Hash("123456",null,2).toString());
//        passwordService.insertOne(password);
        response.sendRedirect(request.getContextPath()+"/admin");
        return null;


    }

    @RequestMapping("/saveuser")
    public String saveUser(Model m,String depart,String name,String birthday,String allergic,String phone,String email,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (depart==null|depart.trim().length()==0||name==null||name.trim().length()==0||birthday==null||birthday.trim().length()==0||allergic==null||allergic.trim().length()==0||phone.trim().length()==0||phone==null||email==null||email.trim().length()==0)
        {
            m.addAttribute("error",JSON.toJSONString(INCOMPLETE_FORM));
            return "Error";
        }
        Patients p=new Patients();
        p.setPName(name);
        p.setPBirthday(birthday);
        p.setPAllergic(allergic);
        p.setPTel(phone);
        p.setPEmail(email);
        p.setPId("C"+RandomStringUtils.random(6,true,true));
        p.setPVisit(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        p.setPDepartment(depart);
        patientsService.save(p);
//        Password password=new Password();
//        password.setUserPhone(phone);
//        password.setPasswordHash(new Md5Hash("123456",null,2).toString());
//        password.setUserId(p.getP_id());
//        passwordService.insertOne(password);
        response.sendRedirect(request.getContextPath()+"/admin");
        return null;
    }
}
