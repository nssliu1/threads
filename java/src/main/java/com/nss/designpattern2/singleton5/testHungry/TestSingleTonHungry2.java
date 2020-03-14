package com.nss.designpattern2.singleton5.testHungry;

import com.nss.designpattern2.singleton5.SingletonHungry;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:23
 * @describe: 使用lambda表达式编写线程
 */
public class TestSingleTonHungry2 {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            new Thread(()->{
                SingletonHungry singletonHungry = SingletonHungry.get();
                System.out.println(singletonHungry);
            }).start();

        }
    }
}
