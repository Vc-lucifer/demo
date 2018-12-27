package com.idea.cms.Queue;

import com.idea.cms.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Tset02")
public class Receiver2 {

    @RabbitHandler
    public void receiver(User user) {
        System.out.println("Test2 receiver2:" + user.password);
    }
}
