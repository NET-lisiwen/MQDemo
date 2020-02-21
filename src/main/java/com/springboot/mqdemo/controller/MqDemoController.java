package com.springboot.mqdemo.controller;

import com.springboot.mqdemo.service.impl.MessageProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: mqdemo
 * @ClassName: MqDemoController
 * @Description: mqdemo
 * @Author: lisiwen
 * @Date: 2020/2/21 13:22
 **/
@RestController
public class MqDemoController {

    @Resource
    MessageProducer messageProducer;

    @PostMapping("/sendMessage/{message}")
    public void sendMessageToMQ(@PathVariable String message) {
        messageProducer.topicExchangeMQDemoKeytest(message);
    }
}
