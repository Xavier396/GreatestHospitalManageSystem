package com.yanghaijia.mapper;

import com.yanghaijia.domain.Medicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author haijiay
* @description 针对表【Medicine】的数据库操作Mapper
* @createDate 2023-04-14 11:43:03
* @Entity com.yanghaijia.domain.Medicine
*/
@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {

}




