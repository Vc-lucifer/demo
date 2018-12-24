package com.idea.cms.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Lucifer
 * @Description: 队列配置，队列的名称，发送者和接受者的名称必须一致，否则接收不到消息
 * @Date: 2018/12/21
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue("Tset01");
    }


    @Bean
    public Queue Queue2() {
        return new Queue("Tset02");
    }


}