package com.yanghaijia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author yanghaijia
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @RequestMapping("home")
    public String gotoDoctor( HttpServletRequest request,HttpServletResponse response) throws IOException {
        //todo 把这么多页面放一起你认真的？改改吧求您了
        Cookie[] cookies=request.getCookies();

            for (Cookie c:cookies)
            {
                if (Objects.equals(c.getName(), "alreadyLogin"))
                {
                    switch (c.getValue())
                    {
                        case "asDoctor":
                            response.sendRedirect(request.getContextPath()+"/doctor");
                            break;
                        case  "asAdmin":
                            response.sendRedirect(request.getContextPath()+"/admin");
                            break;
                        case "Patient":
                            response.sendRedirect(request.getContextPath()+"/user");
                            break;
                        default:
                            return "Login";
                    }
                }
            }

        //todo 如果发现了cookie，那就给我自觉跳转过去
        return "Login";
    }


    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String doLogin(String id, String password, int role, HttpServletRequest request, HttpServletResponse response,boolean savecookie)
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
                response.addCookie(c);

            }
            return "Doctor";
        }
        else if (role==1)
        {
            return "User";
        }
        else if (role==2)
        {
            return "Admin";
        }
        return null;

    }

    @RequestMapping(value = "/about")
    public String about()
    {

        return "About";

    }
}