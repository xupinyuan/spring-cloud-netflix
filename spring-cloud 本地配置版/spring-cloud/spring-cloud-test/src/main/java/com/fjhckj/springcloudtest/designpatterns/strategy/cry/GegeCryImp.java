package com.fjhckj.springcloudtest.designpatterns.strategy.cry;

public class GegeCryImp implements CryInterface{
    @Override
    public void cry() {
        System.out.println("我是咯咯咯叫");
    }
}
