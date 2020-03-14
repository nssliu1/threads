package com.nss.java1.designpattern8.proxy2;

import com.nss.java1.reflect_jdbc6.orm.ProduceClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 22:52
 * @describe:
 */
public class Proxys {
    public static void main(String[] args) throws ClassNotFoundException {
        Station station = new Station();
        StationI stationI = (StationI)Proxy.newProxyInstance(Proxys.class.getClassLoader(), new Class<?>[]{StationI.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("nss");
                Object invoke = method.invoke(station, null);
                return null;
            }
        });
        stationI.seal();


        /*Class<?> aClass = Proxys.class.getClassLoader().loadClass("com.nss.designpattern2.observer1.version1.Display");
        Class<?> aClass1 = StationI.class.getClassLoader().loadClass("com.nss.designpattern2.observer1.version1.Display");
        System.out.println(aClass==aClass1);*/

    }
}

interface StationI{
    public void seal();
}

class Station implements StationI{
    private int ticket = 100;
    public void seal(){
        ticket--;
        System.out.println("buy success");
        System.out.println("剩余"+ticket);
    }
}

class Qunaer{
    private Station station = new Station();
    public void seal(){
        System.out.println("qu na er");
        station.seal();
    }
}

class Person{
    static {
        System.out.println("加载");
    }
    public void buy(Station station){
        station.seal();
    }
    public void buy2(Qunaer qunaer){
        qunaer.seal();
    }
}