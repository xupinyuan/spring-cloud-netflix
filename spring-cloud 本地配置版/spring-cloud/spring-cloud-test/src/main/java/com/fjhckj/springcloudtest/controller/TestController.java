package com.fjhckj.springcloudtest.controller;

import com.fjhckj.springcloudtest.config.ConfigurationPerpretis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ConfigurationPerpretis configurationTest;


    @GetMapping("test")
    public String test(){
        return configurationTest.getAa();
    }

    public void print(){
        System.out.println("111");
    }
}
