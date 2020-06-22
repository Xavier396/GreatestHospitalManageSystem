package com.yanghaijia.dao;

import com.yanghaijia.domain.Staff;
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
}
