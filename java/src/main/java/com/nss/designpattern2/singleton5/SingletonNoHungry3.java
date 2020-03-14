package com.nss.designpattern2.singleton5;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 11:21
 * @describe: 饿汉式加载，会较快造成堆溢出
 * 创建对象分为，
 *          1分配空间1
 *          2构造对象3
 *          3赋值地址的过程2
 * 指令重排序可能执行顺序为1 3 2 造成第二个线程拿到的对象不完整 出错
 */
public class SingletonNoHungry3 {
    private volatile static SingletonNoHungry3 singletonHungry;
    private SingletonNoHungry3(){

    }
    public static SingletonNoHungry3 get(){
        if(singletonHungry == null){//防止多个线程拿锁等待
            synchronized (SingletonNoHungry.class){
                if(singletonHungry == null){//防止同一时刻多个线程进入拿锁并创建
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singletonHungry = new SingletonNoHungry3();//防止指令重排序而对对象做volatile操作
                }
            }
        }
        return singletonHungry;
    }
    public SingletonNoHungry3 get2(){
        synchronized (SingletonNoHungry.class){
            if(singletonHungry == null){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singletonHungry = new SingletonNoHungry3();
            }
        }
        return singletonHungry;
    }
    public void say(){
        System.out.println("hello");
    }

}
