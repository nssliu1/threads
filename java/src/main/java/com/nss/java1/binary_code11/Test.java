package com.nss.java1.binary_code11;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/22 14:07
 * @describe:
 */
public class Test {
    public volatile long sum = 0;

    public int add(int a,int b){
        int temp = a+b;
        sum+=temp;
        return temp;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int sum = 0;
        for (int i =0;i<1000000;i++){
            sum=test.add(sum,i);
        }
        System.out.println("Sum:"+sum);
        System.out.println("Test.sum:"+test.sum);
    }
}
