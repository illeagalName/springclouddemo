package com.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/4 3:23 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqProviderMain8801.class, args);
    }
}
