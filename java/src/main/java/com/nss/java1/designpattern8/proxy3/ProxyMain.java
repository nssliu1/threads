package com.nss.java1.designpattern8.proxy3;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 9:08
 * @describe:
 */
public class ProxyMain {
    public static void main(String[] args) {
        Dog dog = new Dog(new Animal());
        dog.eat();
    }
}
class Animal{

    public void eat(){
        System.out.println("动物吃");
    }
}
class Dog{
    private Animal animal;
    public Dog(Animal animal){
        this.animal = animal;
    }
    public void eat(){
        System.out.println("dog吃");
        this.animal.eat();
    }
    public void eatBrown(){
        System.out.println("aa");
    }

}
