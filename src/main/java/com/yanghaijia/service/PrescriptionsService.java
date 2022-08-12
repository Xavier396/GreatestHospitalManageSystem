package com.yanghaijia.service;

import com.yanghaijia.domain.Prescriptions;

import java.util.List;

/**
 * @author yhjzs
 */
public interface PrescriptionsService {
    public List<Prescriptions> fetchAll();

    public Prescriptions fetchOne(String id);

    public void insertOne(Prescriptions p);
}
