package com.nss.java1.thread2;

import java.util.concurrent.TimeUnit;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 18:09
 * @describe:
 */
public class Joins {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(main.getState());
                    main.interrupt();
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("子线程完毕");
                    System.out.println(main.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("先让子线程运行完毕");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            thread.interrupt();
        }
        System.out.println("主线程完毕");
    }
}
