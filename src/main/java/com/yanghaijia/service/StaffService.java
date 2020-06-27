package com.yanghaijia.service;

import com.yanghaijia.domain.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yhjzs
 */
public interface StaffService {
    public List<Staff> fetchAll();

    public Staff fetchOne(String condition);

    public Boolean isAdmin( String condition );

    public List<Staff> selectSome(int offset, int limit);

    public Integer countAll();

    public List<Staff> fetchSome(String depart, String keywords);
}
