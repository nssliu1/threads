package com.nss.java1.Threads4;

import java.util.concurrent.*;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/11 11:17
 * @describe:
 */
//多线程1
class PrintThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello nss thread");
    }
}
//多线程2
class ReadThread implements Runnable{//任务不会阻塞 不能抛出异常
    int a = 100;//多个线程共享此变量，该变量隶属同一个对象
    @Override
    public void run() {
        try {
            //Thread.sleep(5000);
            while (a>0){

                System.out.println(Thread.currentThread().getName()+"..."+a--);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//多线程3
class ImplCallable implements Callable<Integer> {//传入该任务，任务会阻塞 可以抛出异常

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for(int i=0;i<10;i++){
            result += i;
        }
        System.out.println(Thread.currentThread().getName());
        return result;
    }

}
//线程池1
class ThreadPool{
    public void runThread(){
        //使用Executors工具类中的方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ReadThread demo = new ReadThread();

        //为线程池中的线程分配任务,使用submit方法，传入的参数可以是Runnable的实现类，也可以是Callable的实现类
        for(int i=1;i<=5;i++){
            pool.submit(demo);
        }

        //关闭线程池
        //shutdown ： 以一种平和的方式关闭线程池，在关闭线程池之前，会等待线程池中的所有的任务都结束，不在接受新任务
        //shutdownNow ： 立即关闭线程池
        pool.shutdown();

    }
}
//线程池2
class Excutor{
    private int i = 0;
    public void runThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(;i<50;i++){
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int result = 0;
                    for(int i=0;i<=10;i++){
                        result += i;
                    }
                    System.out.println("aa"+i);
                    if(i==1){
                        Thread.sleep(5000);
                    }
                    return result;
                }
            });
            try {
                System.out.println(Thread.currentThread().getName()+"--"+future.get());
                System.out.println("bb"+i);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
public class Thread1{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new PrintThread().start();

        /*ReadThread readThread = new ReadThread();
        new Thread(readThread).start();
        new Thread(readThread).start();
        new Thread(readThread).start();
        new Thread(readThread).start();*/

        for(int i=0;i<10;i++){
            Callable<Integer> implCallable = new ImplCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
            new Thread(futureTask).start();
            System.out.println(Thread.currentThread().getName()+"----"+futureTask.get());//会阻塞当前线程
            System.out.println("aa");
        }

        //new ThreadPool().runThread();

        //new Excutor().runThread();
        System.out.println("hello liunss main");
    }
}
