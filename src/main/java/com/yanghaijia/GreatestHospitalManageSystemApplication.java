package com.yanghaijia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YHJ
 * <p>
 * CreateDate:2022/8/12
 * <p>
 * CreateTime:16:11
 */
@SpringBootApplication
@MapperScan
public class GreatestHospitalManageSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreatestHospitalManageSystemApplication.class, args);
    }
}
