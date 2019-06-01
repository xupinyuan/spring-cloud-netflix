package com.fjhckj.springcloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认熔断处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public Map<String,String> defaultfallback(){
        Map<String,String> map = new HashMap<>();
        map.put("resultCode","error");
        map.put("resultMessage","网络连接超时");
        map.put("resultObj","null");
        return map;
    }
}