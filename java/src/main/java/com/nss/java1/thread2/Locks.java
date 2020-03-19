package com.nss.java1.thread2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 17:28
 * @describe:
 */
public class Locks {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Locks locks = new Locks();
        Thread thread = new Thread(new TEsts(locks));
        Thread thread1 = new Thread(new TEsts(locks));
        thread.start();
        thread1.start();
        while (true){
            System.out.println(thread.getName()+thread.getState());
            System.out.println(thread1.getName()+thread1.getState());
            Thread.sleep(1000);
        }
    }

    public void print(){

        lock.lock();

        System.out.println(Thread.currentThread().getName()+"lalala");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print2(){
        synchronized (Locks.class){

            System.out.println(Thread.currentThread().getName()+"lalala");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }
}

class TEsts implements Runnable{
    private Locks locks;

    public TEsts(Locks locks) {
        this.locks = locks;
    }

    @Override
    public void run() {
        //locks.print();
        locks.print2();

    }
}
