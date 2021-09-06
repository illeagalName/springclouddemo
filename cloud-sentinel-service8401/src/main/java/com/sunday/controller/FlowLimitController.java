package com.sunday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/6 9:02 下午
 */
@RestController
@RequestMapping("flow")
public class FlowLimitController {
    @GetMapping("testA")
    public String testA(){
        return "-----AAAAA-----";
    }

    @GetMapping("testB")
    public String testB(){
        return "-----BBBBB-----";
    }
}
