package com.nss.java1.enum14;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 16:29
 * @describe:
 */
public class TestEnum {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        Day day = Day.MON;
        Day day1 = Day.MON;
        System.out.println(day.equals(day1));
    }
    public static void test2(){
        Day2 day = Day2.MON;
        Day2 day1 = Day2.WIN;
        System.out.println(day.getDesc());
    }
}
