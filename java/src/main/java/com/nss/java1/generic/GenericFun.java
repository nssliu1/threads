package com.nss.java1.generic;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/3 16:05
 * @describe:
 */
public class GenericFun {
    public <T> T eat(T t){
        System.out.println(t);
        return t;
    }
    public <T extends Number> T eat2(T t){

        System.out.println(t);
        return t;
    }

    @Test
    public void testFun(){
        String fruit = new GenericFun().eat("fruit");
        Integer integer = new GenericFun().eat2(2);
        List<?> list = new ArrayList<>();//会丧失写能力，因为不知道该类型是什么类型的，所以，只能读
        //list.add(1);//报错
        List<? super Number> list2 = new ArrayList<>();//上限是Number,就是Number的子类对象
        list2.add(new Integer(2));
        List<? extends Number> list3 = new ArrayList<>();//下限是Number 就是Number的父类对象

    }
}
