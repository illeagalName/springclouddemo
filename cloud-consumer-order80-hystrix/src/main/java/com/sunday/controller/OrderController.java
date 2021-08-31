package com.sunday.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunday.entities.common.R;
import com.sunday.entities.domain.PaymentDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 2:42 下午
 */
@RestController
@Slf4j
@RequestMapping("order")
@DefaultProperties(defaultFallback = "global_fallback")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-HISTRIX-SERVICE/payment/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("get")
    @HystrixCommand(/*fallbackMethod = "fallback", */commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String getPaymentById(@RequestParam("id") Long id) {
        String object = restTemplate.getForObject(PAYMENT_URL + "error?id=" + id, String.class);
        return object;
    }

    public String fallback(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "  超时，O(∩_∩)O哈哈~ id = " + id;
    }

    public String global_fallback() {
        return "线程池：" + Thread.currentThread().getName() + "  全局配置的异常处理";
    }
}
