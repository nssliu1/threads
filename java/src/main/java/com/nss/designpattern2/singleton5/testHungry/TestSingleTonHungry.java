package com.nss.designpattern2.singleton5.testHungry;

import com.nss.designpattern2.singleton5.SingletonHungry;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:23
 * @describe:
 */
public class TestSingleTonHungry {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonHungry singletonHungry = SingletonHungry.get();
                    System.out.println(singletonHungry);
                }
            }).start();

        }
    }
}
