package com.fjhckj.springcloudfeign.service.hystrix;

import com.fjhckj.springcloudfeign.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImp implements FeignService {
    @Override
    public String helloWorld(String message) {
        return "熔断器触发";
    }
}
