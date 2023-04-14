package com.yanghaijia.mapper;

import com.yanghaijia.domain.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author haijiay
* @description 针对表【Staff】的数据库操作Mapper
* @createDate 2023-04-14 11:43:24
* @Entity com.yanghaijia.domain.Staff
*/
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

}




