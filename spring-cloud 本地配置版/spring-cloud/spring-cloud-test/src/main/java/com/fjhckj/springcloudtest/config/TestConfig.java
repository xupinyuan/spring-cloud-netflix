package com.fjhckj.springcloudtest.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ConfigurationPerpretis.class)
public class TestConfig {


    @Bean
    @ConditionalOnBean(ConfigurationPerpretis.class)//这个配置就是SpringBoot可以优先使用自定义Bean的核心所在，如果没有我们的自定义Bean那么才会自动配置一个新的Bean
    public ConfigurationPerpretis configurationTest(){
        ConfigurationPerpretis configurationTest =new ConfigurationPerpretis();
        configurationTest.setAa("我是@Configguration的值");
        return configurationTest;
    }
}
