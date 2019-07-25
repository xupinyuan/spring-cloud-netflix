package com.fjhckj.springcloudtest.designpatterns.strategy;

import com.fjhckj.springcloudtest.designpatterns.strategy.cry.CryInterface;
import com.fjhckj.springcloudtest.designpatterns.strategy.fly.FlyInterface;

public class GreenDuck extends Duck{

    public GreenDuck() {
    }

    public GreenDuck(String name,CryInterface cryInterface, FlyInterface flyInterface) {
        super(name,cryInterface, flyInterface);
    }


    @Override
    public void display() {
        System.out.println(getName());
        flyInterface.fly();
        cryInterface.cry();
    }
}
