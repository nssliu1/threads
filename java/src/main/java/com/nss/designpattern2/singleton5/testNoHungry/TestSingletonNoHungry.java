package com.nss.designpattern2.singleton5.testNoHungry;

import com.nss.designpattern2.singleton5.SingletonNoHungry;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:56
 * @describe:
 */
public class TestSingletonNoHungry {
    public static void main(String[] args) {
        SingletonNoHungry singletonNoHungry = SingletonNoHungry.get();
        SingletonNoHungry singletonNoHungry1 = SingletonNoHungry.get();
        System.out.println(singletonNoHungry == singletonNoHungry1);
    }
}
