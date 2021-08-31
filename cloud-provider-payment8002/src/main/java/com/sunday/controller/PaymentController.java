package com.sunday.controller;

import com.sunday.entities.common.R;
import com.sunday.entities.domain.PaymentDO;
import com.sunday.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 12:37 下午
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    IPaymentService paymentService;

    @Value("${server.port}")
    Integer port;

    @PostMapping(value = "create")
    public R create(@RequestBody PaymentDO paymentDO) {
        int i = paymentService.create(paymentDO);
        log.info("调用服务端口 {}", port);
        return i > 0 ? R.success() : R.error();
    }

    @GetMapping("get")
    public R<PaymentDO> getPaymentById(@RequestParam("id") Long id) {
        PaymentDO payment = paymentService.getPaymentById(id);
        log.info("调用服务端口 {}", port);
        return R.success(port, "", payment);
    }

    @GetMapping("timeout/test")
    public Integer timeout() {
        return port;
    }
}
