package com.caiquan.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send(){

        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("mqtest","测试内容"+i);
        }

    }
}
