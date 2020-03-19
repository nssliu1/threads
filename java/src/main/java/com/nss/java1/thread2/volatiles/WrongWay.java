package com.nss.java1.thread2.volatiles;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 7:04
 * @describe: 一个想的错误的方法去停止线程
 */
public class WrongWay {

    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        Producer task = new Producer(arrayBlockingQueue);
        Thread produce = new Thread(task);
        produce.start();
        int i = 1000000;
        Consumer consumer = new Consumer(arrayBlockingQueue);
        while (i-->0){
            try {
                System.out.println("消费"+consumer.blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* Thread consumer = new Thread(new Consumer(arrayBlockingQueue));
        consumer.start();*/
        task.vol = false;
    }

}

class Producer implements Runnable{
    public volatile boolean vol = true;
    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true && vol){
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产"+i);
            i++;
        }
    }
}

class Consumer implements Runnable{
    public BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
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
