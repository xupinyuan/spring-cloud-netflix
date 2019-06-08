package com.fjhckj.springcloudredis.controller;

import com.alibaba.fastjson.JSON;
import com.fjhckj.springcloudredis.entity.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 取值
     * @param key
     * @return
     */
    @RequestMapping(value = "get")
    public String get(String key){
        String value;
        try {
            value = (String) redisTemplate.opsForValue().get(key);
            if(StringUtils.isNotBlank(value)){
                value = value.replaceAll("[\\x00-\\x09\\x11\\x12\\x14-\\x1F\\x7F]","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return value;
    }

    /**
     * 写值
     * @param key
     * @param value
     * @param seconds
     * @return
     */
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


    @RequestMapping(value = "test")
    public String test(String key){
        SysUser sysUser = new SysUser();
        sysUser.setId("1");
        sysUser.setUserName("xupinyuan");
        sysUser.setPassword("admin");
        String json = JSON.toJSONString(sysUser);
        redisTemplate.opsForValue().set("json",json,4000);
        Object json1 = redisTemplate.opsForValue().get("json");
        return json1.toString();
    }

}
