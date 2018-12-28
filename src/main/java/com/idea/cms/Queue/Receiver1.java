package com.idea.cms.Queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "Tset01")
public class Receiver1 {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @RabbitHandler
    public void receiver(String user) {
        System.out.println("消息接受时间:"+format.format(new Date()));
        System.out.println("Test1 receiver1:" + user);
        System.out.println("Test1 receiver1:" + user);
        System.out.println("Test1 receiver1:" + user);
        System.out.println("Test1 receiver1:" + user);
    }


}
