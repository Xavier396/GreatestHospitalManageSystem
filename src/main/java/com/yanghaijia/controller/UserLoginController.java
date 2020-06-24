package com.yanghaijia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String doLogin(String id,String password,Integer role)
    {
        if (id.trim().length()==0||password.trim().length()==0)
        {
            System.out.println(role);

            return "Error";
        }
        return null;

    }
}
