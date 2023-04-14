package com.yanghaijia.mapper;

import com.yanghaijia.domain.Patients;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author haijiay
* @description 针对表【Patients】的数据库操作Mapper
* @createDate 2023-04-14 11:43:14
* @Entity com.yanghaijia.domain.Patients
*/
@Mapper
public interface PatientsMapper extends BaseMapper<Patients> {

}




