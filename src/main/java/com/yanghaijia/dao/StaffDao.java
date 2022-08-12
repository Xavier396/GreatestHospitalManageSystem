package com.yanghaijia.dao;

import com.yanghaijia.domain.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface StaffDao {

    @Select("select * from Staff")
    public List<Staff> fetchAll();

    @Select("select * from Staff where worker_id=#{condition} or worker_phone=#{condition}")
    public Staff fetchOne(@Param("condition") String condition);

    @Select("select count(*) from Staff where (worker_id=#{condition} or worker_phone=#{condition}) and worker_role='Admin'")
    public Boolean isAdmin(@Param("condition") String condition);

    @Select("select * from Staff limit #{limit} offset #{offset}")
    public List<Staff> selectSome(@Param("offset") int offset,@Param("limit") int limit);

    @Select("select count(*) from Staff")
    public Integer countAll();

    @Select("select * from Staff where worker_department=#{depart} and (worker_name like '%#{keyword}%' or worker_phone like '%#{keyword}%')")
    public List<Staff> fetchSome(@Param("depart") String depart,@Param("keyword") String keywords);

    @Insert("insert into Staff values(NULL,#{s.worker_id},#{s.worker_name},#{s.worker_birthday},#{s.worker_phone},#{s.worker_email},#{s.worker_department},#{s.worker_other_note},#{s.worker_role})")
    public void insertOne(@Param("s") Staff s);

    @Delete("delete from Staff where worker_id=#{uid}")
    public void  deleteById(@Param("uid") String uid);
}
