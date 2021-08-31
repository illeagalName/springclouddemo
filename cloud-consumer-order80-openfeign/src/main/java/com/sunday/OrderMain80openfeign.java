package com.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 2:40 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderMain80openfeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80openfeign.class, args);
    }
}
