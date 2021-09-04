package com.sunday.service.impl;

import com.sunday.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ami
 * @Date 2021/9/4 3:26 下午
 */
@Component
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    StreamBridge streamBridge;

    @Override
    public void sendMsg() {
        String message = UUID.randomUUID().toString();
        //这里说明一下这个 streamBridge.send 方法的参数 第一个参数是exchange或者topic 就是主题名称
        //默认的主题名称是通过
        //输入:    <方法名> + -in- + <index>
        //输出:    <方法名> + -out- + <index>
        //这里我们接收的时候就要用send方法 参数是consumer<String>接收  详情看8802的controller
        //consumer的参数类型是这里message的类型
        streamBridge.send("sendMsg-out-0", message+ "   sendMsg");
        log.info("************  1  发送了message：{}", message);
    }

    @Override
    public void send2Msg() {
        String message = UUID.randomUUID().toString();
        //这里说明一下这个 streamBridge.send 方法的参数 第一个参数是exchange或者topic 就是主题名称
        //默认的主题名称是通过
        //输入:    <方法名> + -in- + <index>
        //输出:    <方法名> + -out- + <index>
        //这里我们接收的时候就要用send方法 参数是consumer<String>接收  详情看8802的controller
        //consumer的参数类型是这里message的类型
        streamBridge.send("send2Msg-out-0", message + "   send2Msg");
        log.info("************  2  发送了message：{}", message);
    }
}
