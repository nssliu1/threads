package com.nss.java1.classloader5;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/14 17:20
 * @describe:
 */
public class Animal {
    public void eat(String a){
        som(a);
    }
    public void som(String a){
        System.out.println("animal"+a);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat("草");
    }
}

class Dog extends Animal{
    @Override
    public void eat(String a) {
        super.eat(a);
    }

    @Override
    public void som(String a) {
        System.out.println("dog"+a);
    }
}
