package com.fjhckj.springcloudcommonservice.service.hystrix;

import com.fjhckj.springcloudcommonservice.service.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceImp implements RedisService {
    @Override
    public String redisPut(String key, String value, Long seconds) {
        System.out.println("熔断触发调用redis失败");
        return "ERROR";
    }
    @Override
    public String redisGet(String key) {
        System.out.println("熔断触发调用redis失败");
        return null;
    }
}
