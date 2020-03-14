package com.nss.java1.designpattern8.proxy1;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 22:52
 * @describe:
 */
public class Proxys {
    public static void main(String[] args) {
        //new Person().buy(new Station());
        new Person().buy2(new Qunaer());
    }
}
class Station{
    private int ticket = 100;
    public void seal(){
        ticket--;
        System.out.println("buy success");
    }
}
class Qunaer{
    private Station station = new Station();
    public void seal(){
        System.out.println("qu na er");
        station.seal();
    }
}

class Person{
    public void buy(Station station){
        station.seal();
    }
    public void buy2(Qunaer qunaer){
        qunaer.seal();
    }
}