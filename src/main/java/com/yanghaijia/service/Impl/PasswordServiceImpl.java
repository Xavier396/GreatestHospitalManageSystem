package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.PasswordDao;
import com.yanghaijia.domain.Password;
import com.yanghaijia.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    private PasswordDao passwordDao;
    @Override
    public List<Password> fetchAll() {
        return passwordDao.fetchAll();
    }

    @Override
    public Password fetchOne(String s) {
        return passwordDao.fetchOne(s);
    }

    @Override
    public void insertOne(Password password) {
        passwordDao.insertOne(password);
    }
}
