package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.Department;
import com.yanghaijia.dao.DepartmentService;
import com.yanghaijia.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【Department】的数据库操作Service实现
* @createDate 2023-04-14 11:42:54
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




