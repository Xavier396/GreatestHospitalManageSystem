package com.yanghaijia.dao;

import com.yanghaijia.domain.Password;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yhjzs
 */
@Repository
public interface PasswordDao {
    @Select("select * from Password")
    public List<Password> fetchAll();
}
