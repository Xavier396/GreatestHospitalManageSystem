package com.yanghaijia.mapper;

import com.yanghaijia.domain.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author haijiay
* @description 针对表【Department】的数据库操作Mapper
* @createDate 2023-04-14 11:42:54
* @Entity com.yanghaijia.domain.Department
*/
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

}




