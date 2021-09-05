package com.sunday.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/5 3:05 下午
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${nacos.service.payment}")
    String paymentService;

    @GetMapping("get")
    public String get() {
        return restTemplate.getForObject(paymentService + "/payment/get", String.class);
    }
}
