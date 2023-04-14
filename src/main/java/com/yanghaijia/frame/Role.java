package com.yanghaijia.frame;

/**
 * 说明:
 *
 * @author haijiay
 * 创建时间: 2023/4/14 15:13
 */
public enum Role {
    /**
     * 角色代码
     * */
    PATIENTS("0"),DOCTOR("1"),ADMIN("2");

    private String value;

    private Role(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
