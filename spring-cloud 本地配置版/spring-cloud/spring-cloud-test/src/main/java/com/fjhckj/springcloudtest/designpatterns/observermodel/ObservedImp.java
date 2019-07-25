package com.fjhckj.springcloudtest.designpatterns.observermodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class ObservedImp implements Observed{
    private String data;

    List<Observer> observerList = new ArrayList<>();

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        this.noticeObserver();
    }

    /**
     * 添加观察者
     * @return
     */
    @Override
    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    /**
     * 移除观察者
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer){
        if(observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    /**
     * 通知观察者
     */

    public void noticeObserver(){
        for(Observer observer:observerList){
            observer.display(data);
        }
    }


}
