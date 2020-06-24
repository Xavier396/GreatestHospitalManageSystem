package com.yanghaijia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author yanghaijia
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping("doctor")
    public String gotoDoctor( HttpServletRequest request)
    {
        //todo 把这么多页面放一起你认真的？改改吧求您了
        Cookie[] cookies=request.getCookies();

            for (Cookie c:cookies)
            {
                if (Objects.equals(c.getName(), "alreadyLogin"))
                {
                    switch (c.getValue())
                    {
                        case "asDoctor":
                            return "Doctor";
                        case  "asAdmin":
                            return "asAdmin";
                        case "Patient":
                            return "User";

                        default:
                            break;
                    }
                }
            }

        //todo 如果发现了cookie，那就给我自觉跳转过去
        return "Login";
    }


    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String doLogin(String id, String password, Integer role, HttpServletRequest request, HttpServletResponse response,boolean savecookie)
    {

        if (id == null ||id.trim().length()==0|| password == null ||password.trim().length()==0)
        {
            System.out.println(role);

            return "Error";
        }

        else if (role==0)
        {
            if (savecookie)
            {
                Cookie c=new Cookie("alreadyLogin","asDoctor");
                c.setMaxAge(10000);

            }
            return "Admin";
        }
        else if (role==1)
        {
            return "Doctor";
        }
        else if (role==2)
        {
            return "User";
        }
        return null;

    }

    @RequestMapping(value = "/about")
    public String about()
    {

        return "About";

    }
}