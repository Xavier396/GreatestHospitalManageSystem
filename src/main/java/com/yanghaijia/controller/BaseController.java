package com.yanghaijia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanghaijia
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping("doctor")
    public String gotoDoctor()
    {
     return "login";
    }


    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String doLogin(String id,String password,Integer role)
    {
        if (id == null ||id.trim().length()==0|| password == null ||password.trim().length()==0)
        {
            System.out.println(role);

            return "Error";
        }
        return null;

    }

    @RequestMapping(value = "/about")
    public String about()
    {

        return "about";

    }
}