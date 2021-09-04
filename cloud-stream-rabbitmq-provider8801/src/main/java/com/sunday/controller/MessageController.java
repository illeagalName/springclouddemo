package com.sunday.controller;

import com.sunday.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/4 4:19 下午
 */
@RestController
public class MessageController {
    @Autowired
    IMessageProvider messageProvider;

    @GetMapping("sendMsg")
    public void sendMsg() {
        messageProvider.sendMsg();
    }

    @GetMapping("send2Msg")
    public void send2Msg() {
        messageProvider.send2Msg();
    }
}
