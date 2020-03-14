package com.nss.designpattern2.decorator2.version2.update;

import com.nss.designpattern2.decorator2.version2.Guns;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 20:35
 * @describe:
 */
public class GlassDecorate extends Decorates {
    public GlassDecorate(Guns guns) {
        super(guns);
    }
    @Override
    public void added() {
        System.out.println("添加的内容");
    }

}
