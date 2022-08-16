package com.yanghaijia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.PatientsN;
import com.yanghaijia.service.PatientsService;
import com.yanghaijia.mapper.PatientsMapper;
import org.springframework.stereotype.Service;

/**
* @author yhjzs
* @description 针对表【Patients】的数据库操作Service实现
* @createDate 2022-08-15 09:36:06
*/
@Service
public class PatientsServiceImpl extends ServiceImpl<PatientsMapper, PatientsN>
    implements PatientsService{

}




