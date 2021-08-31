package com.sunday.controller;

import com.sunday.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 2:42 下午
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("timeout")
    public Integer getPaymentById() {
        return paymentFeignService.timeout();
    }
}
