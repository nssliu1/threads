package com.nss.java1.Threads4.threadSchedue;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/3 16:35
 * @describe:五个就绪就开始  计数器
 */
public class Counter {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int i = 5;
        while (i-->0){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "就绪");
                    countDownLatch.countDown();
                }
            });
            thread.start();
            //thread.join();
        }
        countDownLatch.await();
        System.out.println("开始");

    }
}
