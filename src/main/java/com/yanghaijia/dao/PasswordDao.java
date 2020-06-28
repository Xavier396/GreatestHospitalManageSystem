package com.yanghaijia.dao;

import com.yanghaijia.domain.Password;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    @Select("select * from Password where user_id=#{id} or user_phone=#{id}")
    public Password fetchOne(@Param("id") String s);

    @Insert("insert into Password values (NULL,#{p.user_phone},#{p.user_id},#{p.password_hash})")
    public void insertOne(@Param("p") Password password);
}
