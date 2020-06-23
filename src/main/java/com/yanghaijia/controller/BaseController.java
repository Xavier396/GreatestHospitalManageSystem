package com.yanghaijia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
