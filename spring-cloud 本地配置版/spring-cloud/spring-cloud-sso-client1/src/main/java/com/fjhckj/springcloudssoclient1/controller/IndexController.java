package com.fjhckj.springcloudssoclient1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = "index")
    public String index(){
        return "系统1--------------登录成功";
    }
}
