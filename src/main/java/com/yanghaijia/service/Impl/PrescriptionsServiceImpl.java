package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.PrescriptionsDao;
import com.yanghaijia.domain.Prescriptions;
import com.yanghaijia.service.PrescriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrescriptionsServiceImpl implements PrescriptionsService {
    @Autowired
    private PrescriptionsDao prescriptionsDao;
    @Override
    public List<Prescriptions> fetchAll() {
        return prescriptionsDao.fetchAll();
    }

    @Override
    public Prescriptions fetchOne(String id) {
        return prescriptionsDao.fetchOne(id);
    }

    @Override
    public void insertOne(Prescriptions p) {
        prescriptionsDao.insertOne(p);
    }
}
