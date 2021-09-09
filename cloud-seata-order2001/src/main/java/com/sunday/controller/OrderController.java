package com.sunday.controller;

import com.sunday.entities.common.R;
import com.sunday.entities.domain.OrderDO;
import com.sunday.service.OrderService;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("create")
    public R<Boolean> create(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer count) {
        return R.success(orderService.create(userId, productId, count));
    }
}
