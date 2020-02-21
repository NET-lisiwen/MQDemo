package com.springboot.mqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: mqdemo
 * @ClassName: TopicExchangeAndBindingConfiguration
 * @Description: 新队列绑定交换机配置类
 * @Author: lisiwen
 * @Date: 2020/2/21 13:36
 **/
@Configuration
public class TopicExchangeAndBindingConfiguration {
    /**
     * 测试队列 routingKey
     */
    @Value("MQDemoKeytest")
    private String MQDemoKeytest;


    /**
     * 注入Topic路由策略的Exchange交换机实例
     *
     * @return 测试“交换机”实例
     */
    @Bean(name = "MQDemoTopicExchange")
    TopicExchange getMQDemoTopicExchange() {
        // 创建并返回名为My-Topic-Exchange的交换机
        return new TopicExchange("MQDemoTopicExchange");
    }

    /**
     * 新建一个队列以监听测试队列
     * MQDemoKeytest
     *
     * @return Queue队列实例
     */
    @Bean(name = "otherQueueMQDemoKeytest")
    public Queue otherQueueMQDemoKeytestMQDemoMQDemoTopic() {
        return new Queue("otherQueueMQDemoKeytest");
    }

    /**
     * 绑定测试队列的队列
     *
     * @param otherQueueMQDemoKeytest 新队列key
     * @param MQDemoTopicExchange 交换机key
     * @return
     */
    @Bean
    Binding bindingGpcmsQueueGpbeExpertAddToGpbeTopicExchange(
            @Qualifier("otherQueueMQDemoKeytest") Queue otherQueueMQDemoKeytest,
            @Qualifier("MQDemoTopicExchange") TopicExchange MQDemoTopicExchange) {
        Binding message = BindingBuilder
                .bind(otherQueueMQDemoKeytest)
                .to(MQDemoTopicExchange)
                .with(MQDemoKeytest);
        return message;
    }


}
