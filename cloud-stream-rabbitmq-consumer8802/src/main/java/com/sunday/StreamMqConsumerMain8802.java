package com.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/4 4:43 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqConsumerMain8802.class, args);
    }
}
