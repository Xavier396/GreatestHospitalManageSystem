package com.yanghaijia.dao;

import com.yanghaijia.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yhjzs
 */
@Mapper
public interface DepartmentDao {
    @Select("select * from Department")
    public List<Department> fetchAll();
}
