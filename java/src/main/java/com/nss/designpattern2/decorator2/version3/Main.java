package com.nss.designpattern2.decorator2.version3;


/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 19:10
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
       Decorator d = new DecoratorGlass(new Gun());
        DecoratorDistanceGlass decoratorDistanceGlass = new DecoratorDistanceGlass(new Gun());
        decoratorDistanceGlass.shout();
        //d.shout();
    }
}
