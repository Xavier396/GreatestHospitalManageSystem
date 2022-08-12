package com.yanghaijia.dao;

import com.yanghaijia.domain.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Mapper
public interface MedicineDao {
    @Select("select * from Medicine")
    public List<Medicine> fetchAll();
}
