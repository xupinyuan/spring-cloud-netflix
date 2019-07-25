package com.fjhckj.springcloudtest.designpatterns.observermodel;

/**
 * 观察者模式
 * 概述：当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 *       比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
 *
 * 案例实现：Observed 接口拥有三个抽象方法addObserver、removeObserver、noticeObserver 分别对应添加、删除、通知
 *           ObservedImp 类继承 Observed 并实现 ObservedImp在被修改时会调用 Observer 定义好的抽象方法通知所有的观察者
 *
 *
 */
public class TestObserverModel {
    public static void main(String[] args) {
        ObservedImp observed = new ObservedImp();
        ObserverImpOne observerImpOne = new ObserverImpOne();
        ObserverImpTow observerImpTow = new ObserverImpTow();
        observed.addObserver(observerImpOne);
        observed.addObserver(observerImpTow);
        observed.setData("通知所有观察者");
        System.out.println("*******************************************************");
        observed.removeObserver(observerImpOne);
        observed.setData("再次通知所有观察者");
    }
}
