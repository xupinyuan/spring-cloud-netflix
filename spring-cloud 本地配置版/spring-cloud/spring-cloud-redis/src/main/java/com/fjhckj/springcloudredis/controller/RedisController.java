package com.fjhckj.springcloudredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @RequestMapping(value = "get")
    public String get(String key){
        String value;
        try {
            value = (String)redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return value;
    }

    @RequestMapping(value = "put")
    public String put(String key,String value,@RequestParam(required = false) Long seconds){
        try {
            if (seconds == null){
                redisTemplate.opsForValue().set(key,value);
            }else {
                redisTemplate.opsForValue().set(key,value,seconds);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }
        return "OK";
    }


    @RequestMapping(value = "delete")
    public String delete(String key){
        Boolean flag = false;
        try {
            flag = redisTemplate.delete(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return String.valueOf(flag);
    }

}
