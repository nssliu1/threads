package com.nss.java1.designpattern8.proxy4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 9:45
 * @describe:
 */
public class DynamicProxyMain {
    public static void main(String[] args) {
        Animal animalProxy = (Animal)Proxy.newProxyInstance(DynamicProxyMain.class.getClassLoader(), new Class[]{Animal.class}, new AnimalProxy());
        animalProxy.eat();//执行那个方法，他会动态代理那个方法
    }
}

class AnimalProxy implements InvocationHandler{
    private MeatAnimal meatAnimal = new MeatAnimal();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("eat")){
            method.invoke(meatAnimal,null);
        }
        return null;
    }
}

interface Animal{
    public void eat();
}
class MeatAnimal implements Animal{
    public void eat(){
        System.out.println("吃肉");
    }
}
