package com.nss.designpattern2.decorator2.version2.update;

import com.nss.designpattern2.decorator2.version2.Guns;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 20:30
 * @describe:模板方法，提供装饰器的模板
 */
public abstract class Decorates {
    public Guns guns;
    public Decorates(Guns guns) {
        this.guns = guns;
    }
    public void shot(){
        this.added();
        guns.shout();
    }
    public abstract void added();
}
