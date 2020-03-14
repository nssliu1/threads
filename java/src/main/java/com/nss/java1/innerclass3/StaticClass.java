package com.nss.java1.innerclass3;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/1 9:48
 * @describe:
 */
public class StaticClass {
    private static int i = 0;

    public static void main(String[] args) {
        StaticCls staticCls = new StaticCls();
        staticCls.pl();
    }
    static class StaticCls{
        public void pl(){
            System.out.println(i);
        }
    }
}
