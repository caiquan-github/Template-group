package com.caiquan.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mqtest")
public class Customer {
    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("消费内容："+msg);
    }
}
