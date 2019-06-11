package com.fjhckj.springcloudrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//开启任务调度
@EnableScheduling
//eureka客户端
@EnableEurekaClient
//接口文档引擎swagger
@EnableSwagger2
@SpringBootApplication
public class SpringCloudRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRabbitmqApplication.class, args);
    }

}
