package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.StaffDao;
import com.yanghaijia.domain.Staff;
import com.yanghaijia.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("StaffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public List<Staff> fetchAll() {
        return staffDao.fetchAll();
    }
}
