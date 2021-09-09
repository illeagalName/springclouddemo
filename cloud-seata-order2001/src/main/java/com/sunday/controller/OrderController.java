package com.sunday.controller;

import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("create")
    public Boolean create(Long userId, Long productId) {
        OrderDO orderDO = OrderDO.builder().count(1).money(BigDecimal.TEN).productId(productId).userId(userId).status(0).build();
        return orderService.create(orderDO);
    }
}
