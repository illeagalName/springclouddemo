package com.sunday.service.impl;

import com.sunday.dao.StorageMapper;
import com.sunday.entities.domain.OrderDO;
import com.sunday.entities.domain.StorageDO;
import com.sunday.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.service.impl
 * @ClassName: OrderServiceImpl
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:47
 * @Version: 1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Boolean changeStorage(Long productId, Integer count) {
        StorageDO storageDO = storageMapper.selectStorageById(productId);
        // 暂时不考虑超卖异常，只管几个服务的事务是否同步
        storageDO.setUsed(storageDO.getUsed() + count);
        storageDO.setResidue(storageDO.getResidue() - count);
        log.info("减库存开始。。。");
        int insert = storageMapper.changeStorage(storageDO);
        log.info("减库存结束。。。");
        return insert > 0;
    }
}
