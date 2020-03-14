package com.nss.java1.string0;

public class TestString {
    public static void testStr1(){
        String str1 = "nssliu";
        String str3 = "nss"+"liu";
        System.out.println(str1 == str3);//true

    }
    public static void testStr2(){
        String str1 = "nssliu";
        String str2 = "nss";
        String str3 = str2+"liu";
        System.out.println(str1 == str3.intern());//true
        System.out.println(str1 == str3);//false;
    }
    public static void testStr3(){
        String str1 = "nssliu";
        String str3 = new String("nssliu");//底层调用StringBuilder
        System.out.println(str1 == str3);//false
    }
    public static void testStr4(){
        String str1 = "nssliu";
        //String str3 = new String("nssliu");
        StringBuilder sb = new StringBuilder("nss");
        sb.append("liu");
        System.out.println(str1 == sb.toString());//false
        System.out.println(str1 == sb.toString().intern());//true 返回常量池引用
    }
    public static void main(String[] args) {
        testStr4();
    }
}
