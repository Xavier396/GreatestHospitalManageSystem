package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.PatientStatus;
import com.yanghaijia.dao.PatientStatusService;
import com.yanghaijia.mapper.PatientStatusMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【patient_status】的数据库操作Service实现
* @createDate 2023-04-14 11:43:09
*/
@Service
public class PatientStatusServiceImpl extends ServiceImpl<PatientStatusMapper, PatientStatus>
    implements PatientStatusService{

}




