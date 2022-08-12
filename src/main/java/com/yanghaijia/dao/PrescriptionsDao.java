package com.yanghaijia.dao;

import com.yanghaijia.domain.Prescriptions;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from Prescriptions where prescription_id=#{id}")
    public Prescriptions fetchOne(@Param("id") String id);
    @Insert("insert into Prescriptions values(NULL,#{p.prescription_id},#{p.prescription_content},#{p.prescription_datetime})")
    public void insertOne(@Param("p") Prescriptions p);
}
