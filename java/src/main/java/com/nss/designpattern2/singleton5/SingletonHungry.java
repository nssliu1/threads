package com.nss.designpattern2.singleton5;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:21
 * @describe: 饿汉式加载，会较快造成堆溢出
 */
public class SingletonHungry {
    private static final SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){

    }
    public static SingletonHungry get(){
        return singletonHungry;
    }
}
