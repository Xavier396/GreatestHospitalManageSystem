package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.DepartmentDao;
import com.yanghaijia.domain.Department;
import com.yanghaijia.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> fetchAll() {
        return departmentDao.fetchAll();
    }
}
