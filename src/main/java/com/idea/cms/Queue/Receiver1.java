package com.idea.cms.Queue;

import com.idea.cms.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Tset01")
public class Receiver1 {

    @RabbitHandler
    public void receiver(User user) {
        System.out.println("Test1 receiver1:" + user.userName);
    }

}
