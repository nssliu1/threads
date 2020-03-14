package com.nss.java1.thread2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/14 23:55
 * @describe:
 */
public class InterruptSignLoop implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while (i<1000 && !Thread.currentThread().isInterrupted()) {
            i--;
            System.out.println("hello nss");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
        System.out.println("asdfas");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptSignLoop());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
