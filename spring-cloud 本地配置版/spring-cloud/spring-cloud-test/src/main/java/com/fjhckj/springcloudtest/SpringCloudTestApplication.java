package com.fjhckj.springcloudtest;

import com.fjhckj.springcloudtest.controller.TestController;
import com.fjhckj.springcloudtest.listener.MyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class SpringCloudTestApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudTestApplication.class);
        //注册事件监听
        springApplication.addListeners(new MyListener());
//        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
//        TestController bean = configurableApplicationContext.getBean(TestController.class);
//        bean.print();
    }




}
