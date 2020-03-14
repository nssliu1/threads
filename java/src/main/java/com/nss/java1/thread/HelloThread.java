package com.nss.java1.thread;

public class HelloThread {
    public static void thread1(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.setName("1");
        t.start();
    }
    public static void thread2(){
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        };
        t.setName("2");
        t.start();
    }
    public static void main(String[] args) {

        HelloThread.thread1();
        HelloThread.thread2();

    }
}
