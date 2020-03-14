package com.nss.designpattern2.decorator2.version1;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 18:58
 * @describe:
 */
public class Sniper extends Gun {
    public void shout(){
        this.glass();
        System.out.println("射击子弹");

    }
    public void glass(){
        System.out.println("瞄准镜");
    }
}
