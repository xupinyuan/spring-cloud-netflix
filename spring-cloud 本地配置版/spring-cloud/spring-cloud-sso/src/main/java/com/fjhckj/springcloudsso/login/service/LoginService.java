package com.fjhckj.springcloudsso.login.service;

import com.fjhckj.springcloudsso.login.service.hystrix.LoginServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-CLOUD-REDIS",fallback = LoginServiceImp.class)
public interface LoginService {
    @RequestMapping(value = "put")
    String redisPut(@RequestParam(name = "key") String key,@RequestParam(name = "value") String value,@RequestParam(name = "seconds") Long seconds);

    @RequestMapping(value = "get")
    String redisGet(@RequestParam(name = "key") String key);
}
