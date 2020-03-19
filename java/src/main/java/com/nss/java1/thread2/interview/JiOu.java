package com.nss.java1.thread2.interview;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/15 16:19
 * @describe:
 */
public class JiOu {
    public static Integer val = 0;

    public static void main(String[] args) {
        JiOus jiOus = new JiOus();
        Thread ji = new Thread(new Ji(jiOus));
        Thread ou = new Thread(new Ou(jiOus));
        ji.start();
        ou.start();
    }


}

class Ji implements Runnable{
    private JiOus jiOus;

    public Ji(JiOus jiOus) {
        this.jiOus = jiOus;
    }

    @Override
    public void run() {
        while (true){
            jiOus.prji();
        }
    }
}
class Ou implements Runnable{
    private JiOus jiOus;


    public Ou(JiOus jiOus) {

        this.jiOus = jiOus;
    }

    @Override
    public void run() {
        while (true)
            jiOus.prou();

    }
}

class JiOus{
    public Integer val = 0;

    public void prji(){
        synchronized (this){
            if(val%2==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            val++;
            notify();
        }
    }
    public void prou(){
        synchronized (this){
            if(val%2!=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            val++;
            notify();
        }
    }
}

