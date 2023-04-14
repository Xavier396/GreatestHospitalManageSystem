package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.Patients;
import com.yanghaijia.dao.PatientsService;
import com.yanghaijia.mapper.PatientsMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【Patients】的数据库操作Service实现
* @createDate 2023-04-14 11:43:14
*/
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, Patients>
    implements PatientsService{

}




