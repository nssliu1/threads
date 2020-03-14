package com.nss.designpattern2.singleton5.testNoHungry;

import com.nss.designpattern2.singleton5.SingletonNoHungry;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:56
 * @describe:
 */
public class TestSingletonNoHungry2 {
    public static void main(String[] args) {
        for(int i =0;i<10;i++){
            new Thread(()->{
                SingletonNoHungry singletonNoHungry = SingletonNoHungry.get();
                System.out.println(singletonNoHungry);
            }).start();

        }
    }
}
