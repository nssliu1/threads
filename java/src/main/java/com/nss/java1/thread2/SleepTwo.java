package com.nss.java1.thread2;

import java.util.concurrent.TimeUnit;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 17:50
 * @describe:
 */
public class SleepTwo implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("中断了");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepTwo());
        thread.start();
        while (true){
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
        }
    }
}
