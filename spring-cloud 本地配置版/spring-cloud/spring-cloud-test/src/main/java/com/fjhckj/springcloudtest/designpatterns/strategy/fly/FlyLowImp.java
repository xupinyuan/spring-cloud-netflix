package com.fjhckj.springcloudtest.designpatterns.strategy.fly;

public class FlyLowImp implements FlyInterface {
    @Override
    public void fly() {
        System.out.println("我飞的很差");
    }
}
