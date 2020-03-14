package com.nss.designpattern2.singleton5;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:21
 * @describe: 饿汉式加载，会较快造成堆溢出
 */
public class SingletonNoHungry {
    private static SingletonNoHungry singletonHungry;
    private SingletonNoHungry(){

    }
    public static SingletonNoHungry get(){
        if(singletonHungry == null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singletonHungry = new SingletonNoHungry();
        }
        return singletonHungry;
    }
}
