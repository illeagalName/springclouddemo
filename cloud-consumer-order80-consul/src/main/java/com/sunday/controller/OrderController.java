package com.sunday.controller;

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
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("get")
    public R<PaymentDO> getPaymentById(@RequestParam("id") Long id) {
        R<PaymentDO> object = restTemplate.getForObject(PAYMENT_URL + "get?id=" + id, R.class);
        return object;
    }
}
