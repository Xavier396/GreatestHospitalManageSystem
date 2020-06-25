package com.yanghaijia.domain;
/**
 * @author yhjzs
 */ //错误类
public class Error {

    private String code;
    private String information;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Error(String code, String information) {
        this.code = code;
        this.information = information;
    }
}
