package com.idea.cms.controller;


import com.idea.cms.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * RabbitMQ - demo
 */
@RestController
@RequestMapping(value = Path.MQ)
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = Path.SEND)
    public String send() {
        String content = "Date:" + new Date();
        amqpTemplate.convertAndSend("Tset01", content);
        return content;
    }

    @RequestMapping(value = Path.MULTI_SEND)
    public String multiSend() {
        StringBuilder times = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("Tset01", "第" + i + "次发送的时间：" + time);
            times.append(time + "<br>");
        }
        return times.toString();
    }

    @RequestMapping(Path.MULTI2_SEND)
    public String mutil2MutilSend() {
        StringBuilder times = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long time = System.nanoTime();
            User user = new User();
            user.userName = "RabbitMQ";
            user.password = "123456";
            amqpTemplate.convertAndSend("Tset01", user);
            amqpTemplate.convertAndSend("Tset02", user);
            times.append(time + "<br>");
        }
        return times.toString();
    }

    @RequestMapping(Path.TOPIC_SEND)
    public String topicSend1() {
        String context = "my topic 1";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.test", context);
        return context;
    }

    @RequestMapping(Path.TOPIC2_SEND)
    public String topicSend2() {
        String context = "my topic 2";
        System.out.println("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return context;
    }


}


