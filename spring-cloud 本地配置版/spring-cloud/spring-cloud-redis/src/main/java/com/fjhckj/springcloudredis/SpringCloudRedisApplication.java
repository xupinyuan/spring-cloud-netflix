package com.fjhckj.springcloudredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRedisApplication.class, args);
    }

}
