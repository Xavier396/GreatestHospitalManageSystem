package com.yanghaijia.service;

import com.yanghaijia.domain.Password;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhjzs
 */
public interface PasswordService {
    public List<Password> fetchAll();

    public Password fetchOne(String s);

    public void insertOne(Password password);
}
