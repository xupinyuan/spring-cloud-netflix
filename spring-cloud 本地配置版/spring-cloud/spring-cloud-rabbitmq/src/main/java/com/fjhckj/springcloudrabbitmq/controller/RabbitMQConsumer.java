package com.fjhckj.springcloudrabbitmq.controller;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
@RabbitListener(queues = "testRabbitQueue")
public class RabbitMQConsumer {

    @RabbitHandler
    public void process(String message){
        System.out.println("我是消费者我要累死了这是消息内容-----"+message);
    }
}
