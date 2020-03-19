package com.nss.java1.thread2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/14 23:55
 * @describe:
 */
public class InterruptWait implements Runnable {
    @Override
    public void run() {
        int i = 0;
        try{
            while (i<100000){
                System.out.println(22);
                i++;
            }
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
                *//*Thread.currentThread().interrupt();
                e.printStackTrace();*//*
            throw new RuntimeException(e);
        }
        System.out.println("nssliu");*/
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptWait());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
