package com.yanghaijia.dao;

import com.yanghaijia.domain.Department;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface DepartmentDao {
    @Select("select * from Department")
    public List<Department> fetchAll();
}
