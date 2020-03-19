package com.nss.java1.thread2.sixstate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 10:04
 * @describe:
 */
public class BlockWaitWaitTime implements Runnable {


    /*@Override
            public void run() {//测试time_waiting
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
    @Override
    public void run() {//测试blocked
        new Blocks().testBlock();
    }

    @Test
    public void testWaittIng() throws InterruptedException {
        Thread thread = new Thread(new BlockWaitWaitTime());
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(10);
        System.out.println(thread.getState());

        Thread.sleep(1000);
        System.out.println(thread.getState());

    }
    @Test
    public void testBlocked() throws InterruptedException {
        Thread thread = new Thread(new BlockWaitWaitTime());
        Thread thread2 = new Thread(new BlockWaitWaitTime());
        System.out.println(thread.getName()+thread.getState());
        System.out.println(thread2.getName()+thread2.getState());


        thread.start();
        thread2.start();
        Thread.sleep(10);
        System.out.println(thread.getName()+thread.getState());
        System.out.println(thread2.getName()+thread2.getState());

        Thread.sleep(10000);
        System.out.println(thread.getName()+thread.getState());
        System.out.println(thread2.getName()+thread2.getState());


    }
    @Test
    public void testWait() throws InterruptedException {
        Wait wait = new Wait();
        Thread thread = new Thread(new Produce(wait));
        Thread thread2 = new Thread(new Consumer(wait));
        thread.start();
        thread2.start();
        while (true){
            Thread.sleep(100);
            System.out.println(thread.getName()+thread.getState());
            System.out.println(thread2.getName()+thread2.getState());
        }

    }
}

class Blocks{

    public void testBlock(){
        synchronized (Blocks.class){

            System.out.println(Thread.currentThread().getName()+"拿到了锁在睡眠");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Wait{
    public List list = new ArrayList();//小于10的容器
    public void produce(){
        synchronized (this){
            try {
                if(list.size()>=10){
                    wait();//进入等待队列，等待notify唤醒重新抢锁
                }
                double random = Math.random();
                System.out.println("生产"+random);
                list.add(random);
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void consume(){
        synchronized (this){
            try{
                if(list.size()<=0){
                    wait();
                }
                System.out.println("消费"+list.remove(0));
                notifyAll();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}


class Produce implements Runnable{
    private Wait wait;

    public Produce() {
    }

    public Produce(Wait wait) {
        this.wait = wait;
    }

    @Override
    public void run() {
        while (true){

            wait.produce();
        }
    }
}
class Consumer implements Runnable{
    private Wait wait;

    public Consumer() {
    }

    public Consumer(Wait wait) {
        this.wait = wait;
    }

    @Override
    public void run() {
        while (true){

            wait.consume();
        }
    }
}
