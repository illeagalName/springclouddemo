package com.sunday.controller;

import com.sunday.dao.OrderMapper;
import com.sunday.entities.common.R;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.controller
 * @ClassName: OrderController
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("create")
    public R<Boolean> create(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer count) {
        BigDecimal money = BigDecimal.ONE.multiply(BigDecimal.valueOf(count));

        // 创建订单不应该在事务里面，这里也写到里面了
        log.info("创建订单开始。。。");
        OrderDO orderDO = OrderDO.builder().count(count).money(money).productId(productId).userId(userId).status(0).build();
        orderMapper.insertOrder(orderDO);
        log.info("创建订单结束。。。");
        return R.success(orderService.create(orderDO));
    }
}
