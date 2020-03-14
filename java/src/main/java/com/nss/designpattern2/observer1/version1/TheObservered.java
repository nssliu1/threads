package com.nss.designpattern2.observer1.version1;

import java.util.ArrayList;
import java.util.List;
/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 9:18
 * @describe:
 */
public class TheObservered implements TheObserver,Display {
    private List observerList = new ArrayList();
    private int all;
    @Override
    public void registObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unRegistObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if(i >= 0){
            observerList.remove(i);
        }

    }

    @Override
    public void updateAllObserver() {
        for (Object obs : observerList){
            Observer obss = (Observer) obs;
            obss.update(this.all);
        }
    }

    @Override
    public void updateData(int all) {
        this.all = all;
        display();
        updateAllObserver();
    }

    @Override
    public void display() {
        System.out.println("当前数据更新为"+this.all);
    }
}
