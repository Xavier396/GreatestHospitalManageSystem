package com.yanghaijia.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanghaijia.domain.Medicine;
import com.yanghaijia.dao.MedicineService;
import com.yanghaijia.mapper.MedicineMapper;
import org.springframework.stereotype.Service;

/**
* @author haijiay
* @description 针对表【Medicine】的数据库操作Service实现
* @createDate 2023-04-14 11:43:03
*/
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine>
    implements MedicineService{

}




