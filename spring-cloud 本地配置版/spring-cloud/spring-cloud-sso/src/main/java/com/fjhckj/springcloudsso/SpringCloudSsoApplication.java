package com.fjhckj.springcloudsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.fjhckj.springcloudsso.dao")
public class SpringCloudSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSsoApplication.class, args);
    }

}
