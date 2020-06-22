package com.yanghaijia.dao;

import com.yanghaijia.domain.Prescriptions;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface PrescriptionsDao {

    @Select("select * from Prescriptions")
    public List<Prescriptions> fetchAll();
}
