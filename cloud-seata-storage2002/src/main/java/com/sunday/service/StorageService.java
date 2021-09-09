package com.sunday.service;

import com.sunday.entities.domain.OrderDO;
import com.sunday.entities.domain.StorageDO;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.service
 * @ClassName: OrderService
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:46
 * @Version: 1.0
 */
public interface StorageService {
    Boolean changeStorage(Long productId, Integer count);
}
