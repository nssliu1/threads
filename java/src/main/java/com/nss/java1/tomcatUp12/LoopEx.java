package com.nss.java1.tomcatUp12;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/22 15:05
 * @describe:
 */
public class LoopEx {
    public static void main(String[] args) {
        Thread thread = new Thread(new Worker());
        thread.start();
    }
    static class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Thread Name:" + Thread.currentThread().getName());
            }
        }
    }
}
