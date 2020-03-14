package com.nss.java1.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/3 15:46
 * @describe:
 */
public class GenericClass<T> {
    private T t;

    public GenericClass(T t) {
        this.t = t;
    }

    public GenericClass() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class GenericClass2<T extends Number> {
    private T t;
    public GenericClass2(T t) {
        this.t = t;
    }

    public GenericClass2() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
class Tests{
    @Test
    public void tests(){
        System.out.println("nss");
        GenericClass<String> gc = new GenericClass<>("nssliu");
        String t = gc.getT();
        System.out.println(t);

        GenericClass<List> gcl = new GenericClass<>();
        List t1 = gcl.getT();
        List<String> list = new ArrayList<>();
        list.get(1);
    }
    @Test
    public void test2(){
        GenericClass2<Integer> gc2 = new GenericClass2<Integer>();
    }
}
