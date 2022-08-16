package com.yanghaijia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.StaffN;
import com.yanghaijia.service.StaffService;
import com.yanghaijia.mapper.StaffMapper;
import org.springframework.stereotype.Service;

/**
* @author yhjzs
* @description 针对表【Staff】的数据库操作Service实现
* @createDate 2022-08-15 09:36:23
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffN>
    implements StaffService{

}




