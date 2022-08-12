package com.yanghaijia.service;

import com.yanghaijia.domain.Patients;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhjzs
 */
public interface PatientsService {
    public List<Patients> fetchAll();

    public List<Patients> fetchByDepartment(String depart);

    public Patients fetchOne(String condition);

    public void insertOne(Patients p);

    public void deleteById(String id);

    public void updatePre(String id,String pid);
}
