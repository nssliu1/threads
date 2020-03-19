package com.nss.java1.thread2;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 18:23
 * @describe:
 */
public class MyJoins {
    public static void main(String[] args) {
        MyJoins myJoins = new MyJoins();
        myJoins.run();

    }

    public void run(){
        //MyJoins myJoins = new MyJoins();



        Thread thread = new Thread(new Jons(this));
        thread.start();
        try {
            synchronized (thread){
                thread.wait();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完毕");

    }


}

class Jons implements Runnable{
    MyJoins myJoins;

    public Jons(MyJoins myJoins) {
        this.myJoins = myJoins;
    }

    @Override
    public void run() {
        s();

    }

    public void s(){

            int i = 0;
            while (i<10){
                i++;
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


    }
}
