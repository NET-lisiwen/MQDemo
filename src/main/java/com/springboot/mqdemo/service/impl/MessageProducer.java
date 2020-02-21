package com.springboot.mqdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ProjectName: mqdemo
 * @ClassName: MessageProducer
 * @Description: 向mq指定队列中放消息
 * @Author: lisiwen
 * @Date: 2020/2/21 13:28
 **/
@Component
public class MessageProducer {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Resource
    private AmqpTemplate amqpTemplate;

    public void topicExchangeMQDemoKeytest(String message) {
        //此消息能匹配上 路由键为“routingKey.#”和“#”的队列
        log.info("向交换机为：MQDemoTopicExchange，队列为：MQDemoKeytest中放入消息：{}",message);
        amqpTemplate.convertAndSend("MQDemoTopicExchange", "MQDemoKeytest", message);
    }
}
