package com.fjhckj.springcloudtest.designpatterns.strategy;

import com.fjhckj.springcloudtest.designpatterns.strategy.cry.GagaCryImp;
import com.fjhckj.springcloudtest.designpatterns.strategy.cry.GegeCryImp;
import com.fjhckj.springcloudtest.designpatterns.strategy.fly.FlyGoodImp;
import com.fjhckj.springcloudtest.designpatterns.strategy.fly.FlyLowImp;

/**
 * 策略模式
 *
 * 概述：在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 *       在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。
 *       策略对象改变 context 对象的执行算法。
 *
 * 案例实现：抽象鸭子超类Duck，在Duck中增加飞行、叫声接口
 *           封装变化特点（飞行、叫声）为接口，为飞行、叫声接口创建不同实现类
 *
 *           鸭子子类可以在对象构建时选用不同的飞行、叫声实现（不同策略算法），从而
 *           在运行时更改飞行、叫声实现不同功能
 */
public class TestStrategy {
    public static void main(String[] args) {
        Duck greenDuck = new GreenDuck("小绿鸭",new GegeCryImp(),new FlyLowImp());
        greenDuck.display();


        Duck redDuck = new RedDuck("小红鸭",new GagaCryImp(),new FlyGoodImp());
        redDuck.display();

    }
}
