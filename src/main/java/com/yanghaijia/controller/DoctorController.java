package com.yanghaijia.controller;

import com.alibaba.fastjson.JSON;
import com.yanghaijia.dao.PatientsService;
import com.yanghaijia.dao.PrescriptionsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static com.yanghaijia.controller.ConstantForController.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
private PrescriptionsService prescriptionsService;
@Autowired
private PatientsService patientsService;

    @RequestMapping("/a/{id}")
    public String  gotoprescr(@PathVariable String id, Model model)
    {
        model.addAttribute("id",id);
        return "Prescript";
    }
    @RequestMapping(value = "/add")
    public String giveout(Model m, String context , String id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if (context.trim().length()==0||context==null)
        {
            m.addAttribute("error", JSON.toJSONString(INCOMPLETE_FORM));
            return "Error";
        }
        Prescriptions p=new Prescriptions();
        p.setPrescriptionDateTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        p.setPrescriptionContent(context);
        String pres="P"+ RandomStringUtils.random(6,true,true);
        p.setPrescriptionId(pres);
        prescriptionsService.insertOne(p);
        patientsService.updatePre(id,pres);

        response.sendRedirect(request.getContextPath());
        return  null;
    }
}
