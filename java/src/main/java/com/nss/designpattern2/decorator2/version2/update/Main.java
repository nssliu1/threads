package com.nss.designpattern2.decorator2.version2.update;

import com.nss.designpattern2.decorator2.version2.Gun;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 20:38
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        Decorates glassDecorate = new GlassDecorate(new Gun());
        glassDecorate.shot();
    }
}
