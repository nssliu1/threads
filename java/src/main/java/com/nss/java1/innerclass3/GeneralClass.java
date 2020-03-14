package com.nss.java1.innerclass3;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/1 10:17
 * @describe:
 */
public class GeneralClass {
    private int i = 0;
    public static void main(String[] args) {
        Inner inner = new GeneralClass().new Inner();
        inner.inner();
    }
    class Inner{
        public void inner(){
            System.out.println(i);
        }
    }
}
