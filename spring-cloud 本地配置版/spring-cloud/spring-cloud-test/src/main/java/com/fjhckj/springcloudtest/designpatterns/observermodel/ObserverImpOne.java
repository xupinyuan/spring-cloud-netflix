package com.fjhckj.springcloudtest.designpatterns.observermodel;

public class ObserverImpOne implements Observer {
    @Override
    public void display(String data) {
        System.out.println( "我是观察者1：接收到被观察者传来的数据："+  data);
    }
}
