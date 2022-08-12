package com.yanghaijia.dao;

import com.yanghaijia.domain.Patients;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface PatientsDao {

    @Select("select * from Patients")
    public List<Patients> fetchAll();

    @Select("select * from Patients where p_id=#{condition} or p_tel=#{condition}")
    public Patients fetchOne(@Param("condition") String condition);

    @Insert("insert into Patients values (NULL,#{p.p_id},#{p.p_name},#{p.p_birthday},#{p.p_allergic},#{p.p_tel},#{p.p_email},#{p.p_visit},#{p.p_prescript_id},#{p.p_department})")
    public void insertOne(@Param("p") Patients p);

    @Delete("delete from Patients where p_id=#{id}")
    public void deleteById(@Param("id") String id);

    @Select("select * from Patients where p_department=#{depart} and p_prescript_id is NULL")
    public List<Patients> fetchByDepartment(String depart);

    @Update("update  Patients set p_prescript_id=#{pid} where p_id=#{id}")
    public void updatePre(@Param("id") String id,@Param("pid") String pid);
}
