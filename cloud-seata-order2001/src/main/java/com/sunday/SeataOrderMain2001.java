package com.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday
 * @ClassName: OrderMain2001
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:36
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class SeataOrderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001.class, args);
    }
}
