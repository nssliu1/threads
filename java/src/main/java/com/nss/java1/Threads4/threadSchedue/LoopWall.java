package com.nss.java1.Threads4.threadSchedue;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/3 16:47
 * @describe: 循环屏障
 */
public class LoopWall {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        int i = 5;
        while (i-->0){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"就绪");
                        cyclicBarrier.await();//都就绪了再开始选择
                        System.out.println(Thread.currentThread().getName()+"选择");
                        cyclicBarrier.await();//都选择完了再开始
                        System.out.println("进入");
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println("开始");
    }

}
