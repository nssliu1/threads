package com.nss.java1.overloading_override2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 14:43
 * @describe:
 */
class Animal{
    public void eat() throws Exception{
        System.out.println("饭");
    }
}
class Dog extends Animal{

    public void eat() throws Exception{
        System.out.println("brone");
    }
}
public class Override {
    public static void main(String[] args) throws Exception {
        Animal animal = new Dog();
        animal.eat();
    }
}
