package com.fjhckj.springcloudtest.designpatterns.strategy.fly;

public class FlyGoodImp implements FlyInterface{
    @Override
    public void fly() {
        System.out.println("我飞的很好");
    }
}
