package com.nss.java1.classloader_gov13;

import com.nss.java1.classloader5.MyClassLoader1;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/21 15:59
 * @describe:
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        /*Set<Class<?>> classes = new LinkedHashSet<>();
        Set<Class<?>> set = PkgUtil2.getClzFromPkg("com.nsliu");*/
        MyClassLoader1 classloader = new MyClassLoader1("E:\\supermap\\work\\2020\\cc\\0createEntity2\\", "myClassloader");
        Class c = classloader.loadClass("Objects");
        Class<?> smdtv_6 = classloader.getParent().loadClass("Objects");
        System.out.println(c.getClassLoader());
        System.out.println(smdtv_6.getClassLoader());
        Class<?> smdtv_61 = Thread.currentThread().getContextClassLoader().loadClass("Objects");
        System.out.println(smdtv_61.getClassLoader());
    }
}
