package com.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 11:00 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHistrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHistrixMain8001.class, args);
    }
}
