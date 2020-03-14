package com.nss.designpattern2.decorator2.version2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 19:01
 * @describe:装饰器
 */
public class DecoratorGlass implements Guns {
    protected Guns gun;

    public DecoratorGlass(Guns gun) {
        this.gun = gun;
    }
    public void shout(){
        this.addGlass();
        gun.shout();
    }
    public void addGlass(){
        System.out.println("瞄准镜");
    }

}
