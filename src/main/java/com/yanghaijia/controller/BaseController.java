package com.yanghaijia.controller;


import com.yanghaijia.service.BaseService;
import com.yanghaijia.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yanghaijia
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @Autowired
     private BaseService baseService;


    @RequestMapping("home")
    public String gotoDoctor(HttpServletRequest request, HttpServletResponse response,Model model)  {

    return   baseService.gotoDoctor(request,response, model);
    }


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String doLogin(@RequestBody LoginVO vo , HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {

       return baseService.doLogin(vo.getId(), vo.getPassword(), vo.getRole(),request,model,response,vo.getSavecookie());

    }

    @RequestMapping(value = "/about")
    public String about() {

        return "About";

    }

    @RequestMapping("/admin")
    public String admin(Model m, HttpServletRequest request) {
        return baseService.admin(m,request);
    }

    @RequestMapping("/doctor")
    public String doctor(Model m, HttpServletResponse response, HttpServletRequest request) {
        return baseService.doctor(m,response,request);
    }

    //安全退出，把cookie和session都给抹了
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response)   {
        baseService.logout(request,response);
    }

    @RequestMapping("/user")
    public String gotoUser() {

        return "User";
    }
}