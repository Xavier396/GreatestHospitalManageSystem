package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.PasswordDao;
import com.yanghaijia.domain.Password;
import com.yanghaijia.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("PasswordService")
public class PasswordServiceImpl implements PasswordService {
    @Autowired
    private PasswordDao passwordDao;
    @Override
    public List<Password> fetchAll() {
        return passwordDao.fetchAll();
    }
}
