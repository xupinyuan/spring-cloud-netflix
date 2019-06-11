package com.fjhckj.springcloudrabbitmq.quartz;

import com.fjhckj.springcloudrabbitmq.controller.RabbitQMController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SendRabbitMQQuartz {
    @Autowired
    private RabbitQMController rabbitQMController;

    /**
     * 每分钟插入1000条消息
     */
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void sendRabbitMQ(){
        for (int i=0 ; i<1000 ; i++){
            rabbitQMController.sendMQ("我是消息"+i);
        }
        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }
    /**
     * 每30秒打印信息
     */
    @Scheduled(cron = "0/30 * * * * ? ")
    public void printTime(){
        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }


}
