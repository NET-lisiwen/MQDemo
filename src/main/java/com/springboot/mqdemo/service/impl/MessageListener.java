package com.springboot.mqdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: mqdemo
 * @ClassName: MessageListener
 * @Description: mq队列消息监听
 * @Author: lisiwen
 * @Date: 2020/2/21 13:29
 **/
@Service
public class MessageListener {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 监听测试队列消息
     * queues中为在配置中绑定的队列名
     * @param message
     */
    @RabbitListener(queues = "otherQueueMQDemoKeytest")
    public void MQDemoKeytestConsumer(String message) {
        log.info("监听到key为：otherQueueMQDemoKeytest的队列中的消息为：{}",message);
    }
}
