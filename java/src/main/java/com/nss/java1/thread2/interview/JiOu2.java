package com.nss.java1.thread2.interview;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 17:01
 * @describe:
 */
public class JiOu2 {
    public static Integer val = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (JiOu2.class){
                        if(val%2==0){
                            System.out.println(Thread.currentThread().getName()+val);
                            val++;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (JiOu2.class){
                        if(val%2!=0){
                            System.out.println(Thread.currentThread().getName()+val);
                            val++;
                        }
                    }
                }
            }
        }).start();
    }
}
