package com.yanghaijia.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明:
 *
 * @author haijiay
 * 创建时间: 2023/4/14 11:44
 */
@Service
public interface BaseService {

    String gotoDoctor(HttpServletRequest request, HttpServletResponse response,Model model);
    String doLogin(String id, String password, String role, HttpServletRequest request, Model model, HttpServletResponse response, String savecookie);
    String  admin(Model m, HttpServletRequest request);
    String doctor(Model m, HttpServletResponse response, HttpServletRequest request);
    void logout(HttpServletRequest request, HttpServletResponse response);
    String gotoUser();

}
