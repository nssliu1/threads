package com.nss.java1.classloader5;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/14 16:03
 * @describe:
 */
public class MainClassLoader{
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyClassLoader1 classloader = new MyClassLoader1("D:\\shenrujava\\file\\1class\\", "myClassloader");
        Class c = classloader.loadClass("Objects");
        MyClassLoader1 classloader2 = new MyClassLoader1("D:\\shenrujava\\file\\1class\\", "myClassloader2");
        Class c2 = classloader2.loadClass("Objects");
        Object o = c2.newInstance();

        System.out.println(c.getClassLoader());
        System.out.println(c2.getClassLoader());
        System.out.println(c == c2);
        System.out.println(c.equals(c2));
        System.out.println(c.getClassLoader().getParent());//自定义的类加载器默认继承AppClassLoader
        System.out.println(c.getClassLoader().getParent().getParent());



        c.newInstance();

        //Class.forName("cmo");
        ClassLoader classLoader = MainClassLoader.class.getClassLoader();//类默认是由AppClassLoader类加载器加载的
        System.out.println(classLoader);
        ClassLoader classLoader2 = MainClassLoader.class.getClassLoader().getParent();
        System.out.println(classLoader2);


    }
}
