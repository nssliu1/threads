package com.nss.designpattern2.decorator2.version2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 19:10
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        DecoratorGlass dg = new DecoratorGlass(new Gun());
        dg.shout();
        DecoratorDistanceGlass ddg = new DecoratorDistanceGlass(new DecoratorGlass(new Gun()));
        ddg.shout();
    }
}
