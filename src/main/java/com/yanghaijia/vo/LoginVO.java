package com.yanghaijia.vo;

import lombok.Data;

/**
 * 说明:
 *
 * @author haijiay
 * 创建时间: 2023/4/14 13:44
 */


@Data
public class LoginVO {
    private  String id;
    private String password;
    private String role;
    private  String savecookie;
}
