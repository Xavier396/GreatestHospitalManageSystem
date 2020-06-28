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

    @Override
    public Staff fetchOne(String condition) {
        return staffDao.fetchOne(condition);
    }

    @Override
    public Boolean isAdmin(String condition) {
        return staffDao.isAdmin(condition);
    }

    @Override
    public List<Staff> selectSome(int offset, int limit) {
        return staffDao.selectSome(offset,limit);
    }

    @Override
    public Integer countAll() {
        return staffDao.countAll();
    }

    @Override
    public List<Staff> fetchSome(String depart, String keywords) {
        return staffDao.fetchSome(depart,keywords);
    }

    @Override
    public void insertOne(Staff s) {
        staffDao.insertOne(s);
    }

    @Override
    public void deleteById(String uid) {
        staffDao.deleteById(uid);
    }
}
