package com.yanghaijia.test;

import com.yanghaijia.service.StaffService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Testing {

    @Autowired
    private StaffService staffService;
    @Test
    public void ceshi()  {
        System.out.println(staffService.isAdmin("17858674587"));

    }

}
