package com.yanghaijia.service;

import com.yanghaijia.domain.Password;

import java.util.List;

/**
 * @author yhjzs
 */
public interface PasswordService {
    public List<Password> fetchAll();

    public Password fetchOne(String s);
}
