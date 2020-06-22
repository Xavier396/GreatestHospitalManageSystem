package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.PatientsDao;
import com.yanghaijia.domain.Patients;
import com.yanghaijia.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PatientsService")
public class PatientsServiceImpl implements PatientsService {
    @Autowired
    private PatientsDao patientsDao;
    @Override
    public List<Patients> fetchAll() {
        return patientsDao.fetchAll();
    }
}
