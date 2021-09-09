package com.sunday.service.impl;

import com.sunday.dao.OrderMapper;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    public Boolean create(Long userId, Long productId, Integer count) {
        log.info("创建订单开始。。。");
        OrderDO orderDO = OrderDO.builder().count(count).money(BigDecimal.ONE.multiply(BigDecimal.valueOf(count))).productId(productId).userId(userId).status(0).build();
        orderMapper.insertOrder(orderDO);
        log.info("创建订单结束。。。");

        // 扣减库存和资产后修改订单状态
        orderDO.setStatus(1);
        int i = orderMapper.updateOrder(orderDO);
        return i > 0;
    }
}
