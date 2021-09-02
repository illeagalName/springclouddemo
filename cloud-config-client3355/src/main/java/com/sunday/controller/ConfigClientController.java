package com.sunday.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/2 11:15 下午
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${a.b}")
    private String configInfo;

    @GetMapping("configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
