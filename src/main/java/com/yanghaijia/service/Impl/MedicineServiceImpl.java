package com.yanghaijia.service.Impl;

import com.yanghaijia.dao.MedicineDao;
import com.yanghaijia.domain.Medicine;
import com.yanghaijia.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDao;
    @Override
    public List<Medicine> fetchAll() {
        return medicineDao.fetchAll();
    }
}
