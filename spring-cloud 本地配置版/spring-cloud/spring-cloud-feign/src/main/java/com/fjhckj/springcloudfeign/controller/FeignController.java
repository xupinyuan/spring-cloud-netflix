package com.fjhckj.springcloudfeign.controller;

import com.fjhckj.springcloudfeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "spring-cloud-feign")
public class FeignController {
    @Autowired
    public FeignService feignService;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "hello-feign")
    public String helloFeign(String message) {
        return feignService.helloWorld(message);
    }

    @RequestMapping(value = "hello-ribbon")
    public String helloRibbon(String message) {
        return restTemplate.getForObject("http://SPRING-CLOUD-SERVICE/spring-cloud-service/hello-world?message=" + message, String.class);
    }
}
