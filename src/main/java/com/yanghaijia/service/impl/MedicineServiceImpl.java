package com.yanghaijia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.MedicineN;
import com.yanghaijia.service.MedicineService;
import com.yanghaijia.mapper.MedicineMapper;
import org.springframework.stereotype.Service;

/**
* @author yhjzs
* @description 针对表【Medicine】的数据库操作Service实现
* @createDate 2022-08-15 09:35:56
*/
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, MedicineN>
    implements MedicineService{

}




