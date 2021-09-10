package com.sunday.service.impl;

import com.sunday.api.RemoteAccountService;
import com.sunday.api.RemoteStorageService;
import com.sunday.dao.OrderMapper;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    RemoteStorageService remoteStorageService;

    @Resource
    RemoteAccountService remoteAccountService;

    @Override
    public Boolean create(Long userId, Long productId, Integer count) {
        log.info("流程开始");
        BigDecimal money = BigDecimal.ONE.multiply(BigDecimal.valueOf(count));

        log.info("创建订单开始。。。");
        OrderDO orderDO = OrderDO.builder().count(count).money(money).productId(productId).userId(userId).status(0).build();
        orderMapper.insertOrder(orderDO);
        log.info("创建订单结束。。。");

        log.info("扣库存开始。。。");
        remoteStorageService.changeStorage(productId, count);
        log.info("扣库存开始。。。");

        log.info("扣资产开始。。。");
        remoteAccountService.changeAccount(userId, money);
        log.info("扣资产开始。。。");

        // 扣减库存和资产后修改订单状态
        orderDO.setStatus(1);
        log.info("修改订单状态完结");
        int i = orderMapper.updateOrder(orderDO);
        log.info("流程结束");
        return i > 0;
    }
}
