package com.nss.java1.thread2.volatiles;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 7:04
 * @describe: 一个想的错误的方法去停止线程
 */
public class TrueWay {

    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        Producers task = new Producers(arrayBlockingQueue);
        Thread produce = new Thread(task);
        produce.start();
        int i = 100000;
        Consumers consumer = new Consumers(arrayBlockingQueue);
        while (i-->0){
            try {
                System.out.println("消费"+consumer.blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* Thread consumer = new Thread(new Consumer(arrayBlockingQueue));
        consumer.start();*/
        produce.interrupt();
    }

}

class Producers implements Runnable{
    public volatile boolean vol = true;
    private BlockingQueue blockingQueue;

    public Producers(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true && !Thread.currentThread().isInterrupted()){
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("生产"+i);
            i++;
        }
    }
}

class Consumers implements Runnable{
    public BlockingQueue blockingQueue;

    public Consumers(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("消费了"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
