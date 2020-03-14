package com.nss.designpattern2.observer1.version1;
/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 9:18
 * @describe:
 */
public class Observered implements Observer,Display {
    private int all;
    @Override
    public void update(int all) {
        this.all = all;
        display();
    }

    @Override
    public void display() {
        System.out.println("观察者数据已经更新为"+this.all);
    }
}
