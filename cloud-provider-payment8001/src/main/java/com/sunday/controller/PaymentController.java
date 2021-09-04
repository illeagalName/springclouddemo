package com.sunday.controller;

import com.sunday.entities.common.R;
import com.sunday.entities.domain.PaymentDO;
import com.sunday.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping(value = "create")
    public R create(@RequestBody PaymentDO paymentDO) {
        int i = paymentService.create(paymentDO);
        log.info("调用服务端口 {}", port);
        return i > 0 ? R.success() : R.error();
    }

    @GetMapping("get/test")
    public R<PaymentDO> getPaymentById(@RequestParam("id") Long id) {
        PaymentDO payment = paymentService.getPaymentById(id);
        log.info("调用服务端口 {}", port);
        return R.success(port, "", payment);
    }

    @GetMapping("timeout")
    public Integer timeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("discovery")
    public R<DiscoveryClient> getPaymentById() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service : {}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance : {}  {}  {}  {}  {}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getServiceId(), instance.getUri().toString());
        }
        return R.success(discoveryClient);
    }

    @GetMapping("zipkin")
    public String paymentZipkin(){
        return "Hi, test zipKin ,you can see see  ";
    }
}
