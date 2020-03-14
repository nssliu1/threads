package com.nss.java1.lists;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/31 9:08
 * @describe:
 */
public class Objects {
    static Object [] objects = new Object[]{};
    public static void main(String[] args) {
        System.out.println(objects.getClass() == Object[].class);
    }
}
