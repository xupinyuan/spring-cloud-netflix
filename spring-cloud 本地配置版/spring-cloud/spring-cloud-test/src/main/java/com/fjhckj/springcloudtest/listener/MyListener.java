package com.fjhckj.springcloudtest.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring 监听类
 * ApplicationStartedEvent ：spring boot启动开始时执行的事件
 * ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建。
 * ApplicationPreparedEvent：spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
 * ApplicationFailedEvent：spring boot启动异常时执行事件
 */
public class MyListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------" +
                "我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------" +
                "我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------" +
                "我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------我是事件监听-------------");
    }
}
