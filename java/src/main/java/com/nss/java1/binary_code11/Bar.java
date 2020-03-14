package com.nss.java1.binary_code11;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/22 11:13
 * @describe:
 */
public class Bar {
    int a=1;
    static int b=2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args){
        new Bar().sum(3);
    }
}