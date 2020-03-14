package com.nss.designpattern2.decorator2.version1;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 19:00
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        Gun gun = new Sniper();
        gun.shout();
    }
}
