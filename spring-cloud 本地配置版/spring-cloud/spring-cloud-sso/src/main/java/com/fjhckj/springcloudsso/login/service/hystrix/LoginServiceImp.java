package com.fjhckj.springcloudsso.login.service.hystrix;

import com.fjhckj.springcloudsso.login.service.LoginService;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImp implements LoginService {
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
