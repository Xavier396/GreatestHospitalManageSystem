package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.Prescriptions;
import com.yanghaijia.dao.PrescriptionsService;
import com.yanghaijia.mapper.PrescriptionsMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【Prescriptions】的数据库操作Service实现
* @createDate 2023-04-14 11:43:19
*/
@Service
public class PrescriptionsServiceImpl extends ServiceImpl<PrescriptionsMapper, Prescriptions>
    implements PrescriptionsService{

}




