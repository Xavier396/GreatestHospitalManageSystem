package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.Staff;
import com.yanghaijia.dao.StaffService;
import com.yanghaijia.mapper.StaffMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【Staff】的数据库操作Service实现
* @createDate 2023-04-14 11:43:24
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
    implements StaffService{

}




