package com.nss.java1.lambda15;

import com.nss.java1.lambda15.one.User;
import com.nss.java1.lambda15.three.User3;
import com.nss.java1.lambda15.two.User2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 16:40
 * @describe:
 */
public class TestLambda {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    public static void test1() {
        userEat(()->{
            System.out.println("吃");
        });
    }
    public static void test2() {
        userEat2((String food)->{
            System.out.println(food);
        });
    }

    public static void test3() {
        userEat3((int k)->{
           return k-2;
        });
    }
    public static void userEat(User user){
        user.eat();
    }

    public static void userEat2(User2 user){
        user.eat("food");
    }
    public static void userEat3(User3 user){
        int eat = user.eat(5);
        System.out.println(eat);
    }


}
