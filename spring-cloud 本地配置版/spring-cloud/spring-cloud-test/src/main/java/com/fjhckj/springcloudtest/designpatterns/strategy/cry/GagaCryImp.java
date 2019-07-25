package com.fjhckj.springcloudtest.designpatterns.strategy.cry;

public class GagaCryImp implements CryInterface{
    @Override
    public void cry() {
        System.out.println("我是嘎嘎嘎叫");
    }
}
