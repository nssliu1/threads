package com.nss.java1.thread2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/14 23:55
 * @describe:
 */
public class InterruptSign implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("hello nss");


        }
        System.out.println("asdfas");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptSign());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
