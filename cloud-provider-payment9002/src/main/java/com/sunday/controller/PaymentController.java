package com.sunday.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/5 2:21 下午
 */
@RestController
@RequestMapping("payment")
@RefreshScope
public class PaymentController {

    @Value("${server.port}")
    String port;

    @Value("${a.b}")
    String ab;

    @GetMapping("get")
    public String get() {
        return "payment-service " + port + "   " + ab;
    }
}
