package com.nss.designpattern2.singleton5.testEnumSingleton;

import com.nss.designpattern2.singleton5.SingletonEnum4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 16:22
 * @describe:
 */
public class TestEnumSingleton {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
       //test1();
       test2();
    }

    public static void test1() {
        SingletonEnum4.INSTANCE.getInstance();
    }
    public static void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<SingletonEnum4> singletonEnum4Class = SingletonEnum4.class;
        Constructor<SingletonEnum4> declaredConstructor = singletonEnum4Class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        SingletonEnum4 singletonEnum4 = declaredConstructor.newInstance();

    }
}
