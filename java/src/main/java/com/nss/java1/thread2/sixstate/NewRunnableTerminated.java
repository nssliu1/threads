package com.nss.java1.thread2.sixstate;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 9:58
 * @describe:
 */
public class NewRunnableTerminated implements Runnable {
    @Override
    public void run() {
        try {
            int i = 100000;
            while (i-->0)
                System.out.print(2);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(1);
        System.out.println(thread.getState());
        Thread.sleep(1000);
        System.out.println(thread.getState());


    }
}
