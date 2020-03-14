package com.nss.designpattern2.singleton5.testNoHungary3;

import com.nss.designpattern2.singleton5.SingletonNoHungry3;

import java.lang.reflect.Constructor;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 12:03
 * @describe:
 */
public class TestNoHungry3 {
    public static void main(String[] args) {
        test1();
    }
    public static void test2(){
        for (int i = 0;i<10;i++){
            new Thread(()->{
                Class<SingletonNoHungry3> singletonNoHungry3Class = SingletonNoHungry3.class;
                try {
                    Constructor<SingletonNoHungry3> constructor = singletonNoHungry3Class.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    SingletonNoHungry3 singletonNoHungry31 = constructor.newInstance();
                    System.out.println(singletonNoHungry31);
                    /*SingletonNoHungry3 singletonNoHungry32 = singletonNoHungry31.get2();
                    System.out.println(singletonNoHungry32);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    public static void test1(){
        for(int i = 0;i<10;i++){
            new Thread(()->{
                SingletonNoHungry3 singletonNoHungry3 = SingletonNoHungry3.get();
                System.out.println(singletonNoHungry3);
            }).start();
        }
    }
}
