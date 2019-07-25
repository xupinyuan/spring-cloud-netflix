package com.fjhckj.springcloudtest.designpatterns.strategy;

import com.fjhckj.springcloudtest.designpatterns.strategy.cry.CryInterface;
import com.fjhckj.springcloudtest.designpatterns.strategy.fly.FlyInterface;

public abstract class Duck {
    CryInterface cryInterface;
    FlyInterface flyInterface;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duck(){

    }

    public Duck(String name ,CryInterface cryInterface,FlyInterface flyInterface){
        this.name = name;
        this.cryInterface = cryInterface;
        this.flyInterface = flyInterface;
    }

    public void fly(){
        flyInterface.fly();
    }
    public void cry(){
        cryInterface.cry();
    }

    public CryInterface getCryInterface() {
        return cryInterface;
    }

    public void setCryInterface(CryInterface cryInterface) {
        this.cryInterface = cryInterface;
    }

    public FlyInterface getFlyInterface() {
        return flyInterface;
    }

    public void setFlyInterface(FlyInterface flyInterface) {
        this.flyInterface = flyInterface;
    }

    public abstract void display();
}
