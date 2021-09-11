package com.sunday.service.impl;

import com.alibaba.fastjson.JSON;
import com.sunday.api.RemoteAccountService;
import com.sunday.api.RemoteStorageService;
import com.sunday.dao.OrderMapper;
import com.sunday.entities.common.R;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    // 模拟异常的话，需要将feign.sentinel.enabled设置为false，不能使用降级兜底策略
    public Boolean create(OrderDO orderDO) {
        log.info("流程开始");

        BigDecimal money = orderDO.getMoney();
        Integer count = orderDO.getCount();
        Long productId = orderDO.getProductId();
        Long userId = orderDO.getUserId();

        log.info("扣库存开始。。。");
        R<Boolean> booleanR = remoteStorageService.changeStorage(productId, count);
        log.info("扣库存返回数据 {}", JSON.toJSONString(booleanR));
        log.info("扣库存开始。。。");

        log.info("扣资产开始。。。");
        R<Boolean> booleanR1 = remoteAccountService.changeAccount(userId, money);
        log.info("扣资产返回数据 {}", JSON.toJSONString(booleanR1));
        log.info("扣资产开始。。。");

        // 扣减库存和资产后修改订单状态
        orderDO.setStatus(1);
        log.info("修改订单状态完结");
        int i = orderMapper.updateOrder(orderDO);
        log.info("流程结束");
        return i > 0;
    }
}
