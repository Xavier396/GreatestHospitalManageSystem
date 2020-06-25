package com.yanghaijia.controller;

import com.alibaba.fastjson.JSON;
import com.yanghaijia.domain.Error;
import com.yanghaijia.domain.Password;
import com.yanghaijia.service.PasswordService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping("home")
    public String gotoDoctor( HttpServletRequest request,HttpServletResponse response) throws IOException {

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
        return "Login";
    }


    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String doLogin(String id, String password, String role, HttpServletRequest request, Model model,HttpServletResponse response,String savecookie)
    {

        if (id == null ||id.trim().length()==0|| password == null ||password.trim().length()==0)
        {
//           errorNavigator(model,INCOMPLETE_FORM);
            String json=JSON.toJSONString(INCOMPLETE_FORM);
            model.addAttribute("error",json);
            return "Error";
        }

        else if (TEXT_ZERO.equals(role))
        {
            //TODO 做一个数据库的查询，判断到你的数据库有没有这个账号 表单验证之类的

            if (CHECK_BOX_CHECKED.equals(savecookie))
            {
                Cookie c=new Cookie("alreadyLogin","asDoctor");
                c.setMaxAge(10000);
                response.addCookie(c);
            }
            return "Doctor";
        }
        else if (TEXT_ONE.equals(role))
        {
            //TODO 做一个数据库的查询，判断到你的数据库有没有这个账号 表单验证之类的
            if (CHECK_BOX_CHECKED.equals(savecookie))
            {
                Cookie c=new Cookie("alreadyLogin","asUser");
                c.setMaxAge(10000);
                response.addCookie(c);
            }
            return "User";
        }
        else if (TEXT_TWO.equals(role))
        {
            String passwordHash = new Md5Hash(password,null,2).toString();
            System.out.println("note1:"+passwordHash);
            Password ps=passwordService.fetchOne(id);
            System.out.println("note2:"+JSON.toJSONString(ps));
            if (ps==null)
            {
                String error=JSON.toJSONString(NO_SUCH_USER);
                model.addAttribute("error",error);
                return "Error";
            }
            else if (!Objects.equals(ps.getPasswordHash(), passwordHash))
            {
                String error=JSON.toJSONString(VERIFICATION_FAIL);
                model.addAttribute("error",error);
                return "Error";
            }
            if (CHECK_BOX_CHECKED.equals(savecookie))
            {
                Cookie c=new Cookie("alreadyLogin","asAdmin");
                c.setMaxAge(10000);
                response.addCookie(c);
            }
            return "Admin";
        }
        return null;

    }

    @RequestMapping(value = "/about")
    public String about()
    {

        return "About";

    }
    /**
     * @param m model,spring存放的参数
     *
     * @param errorCode ，错误代码，可以直接新建(不推荐)，也可以从常量类里面取得
     *
     * */
//    private String errorNavigator(Model m, Error errorCode)
//    {
//        String json= JSON.toJSONString(errorCode);
//        m.addAttribute("error",json);
//        return "Error";
//    }
}