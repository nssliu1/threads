package com.nss.java1.thread;

public class ExtendsThread extends Thread {
    @Override
    public void run(){
        System.out.println("nss");
    }
    public static void main(String[] args) {
        new ExtendsThread().start();
    }
}
