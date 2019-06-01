package com.fjhckj.springcloudfeign.service;

import com.fjhckj.springcloudfeign.service.hystrix.FeignServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "spring-cloud-service", fallback = FeignServiceImp.class)
public interface FeignService {
    @RequestMapping(value = "spring-cloud-service/hello-world", method = RequestMethod.GET)
    String helloWorld(@RequestParam("message") String message);
}
