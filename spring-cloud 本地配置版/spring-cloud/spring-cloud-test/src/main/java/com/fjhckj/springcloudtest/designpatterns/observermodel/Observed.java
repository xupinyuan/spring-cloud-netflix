package com.fjhckj.springcloudtest.designpatterns.observermodel;

public interface Observed  {
     void addObserver(Observer observer);
     void removeObserver(Observer observer);
     void noticeObserver();
}
