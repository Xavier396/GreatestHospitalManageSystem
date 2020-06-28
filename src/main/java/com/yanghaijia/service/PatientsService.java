package com.yanghaijia.service;

import com.yanghaijia.domain.Patients;

import java.util.List;

/**
 * @author yhjzs
 */
public interface PatientsService {
    public List<Patients> fetchAll();

    public Patients fetchOne(String condition);

    public void insertOne(Patients p);
}
