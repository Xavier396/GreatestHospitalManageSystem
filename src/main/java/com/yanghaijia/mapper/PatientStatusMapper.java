package com.yanghaijia.mapper;

import com.yanghaijia.domain.PatientStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author haijiay
* @description 针对表【patient_status】的数据库操作Mapper
* @createDate 2023-04-14 11:43:09
* @Entity com.yanghaijia.domain.PatientStatus
*/
@Mapper
public interface PatientStatusMapper extends BaseMapper<PatientStatus> {

}




