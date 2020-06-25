package com.yanghaijia.dao;

import com.yanghaijia.domain.Patients;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface PatientsDao {

    @Select("select * from Patients")
    public List<Patients> fetchAll();


}
