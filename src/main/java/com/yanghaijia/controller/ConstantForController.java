package com.yanghaijia.controller;

import com.yanghaijia.frame.Error;

/**
 * @author yhjzs
 * <p>
 * Controller们的常量类
 * <p>
 * 权限部分
 * {@value #TEXT_ZERO} TEXT_ZERO就是字符0，在这里字符0象征医生权限
 * {@value #TEXT_ONE} TEXT_TWO是字符1，表示病人
 * {@value #TEXT_TWO} TEXT_TWO是字符2，表示管理员
 * <p>
 * checkBox
 * {@value #CHECK_BOX_CHECKED} CHECK_BOX_CHECKED指选择框被勾选了的状态，但是html里面没有true
 * <p>
 * 错误代码
 * {@value #INCOMPLETE_FORM} IMCOMPLETE_FORM，账号输入错误，返回此错误
 */
public class ConstantForController {

    public static final String TEXT_ZERO = "0";
    public static final String TEXT_ONE = "1";
    public static final String TEXT_TWO = "2";

    public static final String CHECK_BOX_CHECKED = "on";


    public static final Error INCOMPLETE_FORM = new Error("E001", "填写的内容不完全");
    public static final Error NO_SUCH_USER = new Error("E002", "无此用户");
    public static final Error VERIFICATION_FAIL = new Error("E003", "验证错误，请检查密码");
    public static final Error WRONG_ROLE = new Error("E004", "错误的用户角色");


}
