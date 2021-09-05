package com.sunday.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RefreshScope
public class PaymentController {

    @Value("${server.port:}")
    String port;
    @Value("${a.b}")
    String ab;

    @GetMapping("get")
    public String get() {
        String s = "payment-service " + port + "  " + ab;
        log.info("日志 {}", s);
        return s;
    }
}
