package com.fjhckj.springcloudrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    /**
     * 创建一个消息队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("testRabbitQueue");
    }
}
