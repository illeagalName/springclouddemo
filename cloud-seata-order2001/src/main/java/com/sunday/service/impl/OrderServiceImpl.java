package com.sunday.service.impl;

import com.sunday.dao.OrderMapper;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Boolean create(OrderDO orderDO) {
        log.info("创建订单开始。。。");
        int insert = orderMapper.insert(orderDO);
        log.info("创建订单结束。。。");
        return insert > 0;
    }
}
