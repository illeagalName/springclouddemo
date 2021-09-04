package com.sunday.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/4 4:44 下午
 */
@Configuration
@Slf4j
public class MessageConsumer {
    @Bean
    public Consumer<String> consumeMsg() {
        return System.out::println;
    }

    @Bean
    public Consumer<String> consume2Msg() {
        return System.out::println;
    }

}
