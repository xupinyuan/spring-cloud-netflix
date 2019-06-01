package com.fjhckj.springcloudservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "spring-cloud-service")
public class ServiceController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hello-world")
    public String helloWorld(String message) {
        return "hi spring-cloud-service hello-world" + message + "------端口号是" + port;
    }


    @RequestMapping("/timeOutTest")
    public String timeOutTest(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "熔断测试";
    }
}
