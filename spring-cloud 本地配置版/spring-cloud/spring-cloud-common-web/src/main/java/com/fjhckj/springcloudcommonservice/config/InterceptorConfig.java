package com.fjhckj.springcloudcommonservice.config;

import com.fjhckj.springcloudcommonservice.interceptor.WebInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器初始化配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 解决拦截器不能注入bean 问题
     * @return
     */
    @Bean
    WebInterceptor WebInterceptor(){
        return new WebInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(WebInterceptor()).addPathPatterns("/**");
    }
}