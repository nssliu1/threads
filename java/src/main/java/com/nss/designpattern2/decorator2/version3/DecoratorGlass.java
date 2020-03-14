package com.nss.designpattern2.decorator2.version3;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 19:23
 * @describe:
 */
public class DecoratorGlass extends Decorator {
    public DecoratorGlass(Guns gun) {
        super(gun);
    }
    public void shout(){
        this.addGlass();
        gun.shout();
    }
    public void addGlass(){
        System.out.println("瞄准镜");
    }
}
