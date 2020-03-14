package com.nss.java1.annotation7;

import java.lang.annotation.Annotation;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/12 19:48
 * @describe:
 */
@Tables(name = "nssliu")
@Book(name = "nss",publishDate = "20191113",author = "liuzh")
public class TestAnno {
    @Propertys
    private static String name;
    @Methods
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        getDetailOfclassAnno();
    }
    //获取注解属性值
    public static void getDetailOfclassAnno(){
        Class<?> testAnnoClass = TestAnno.class;
        Tables annotation = testAnnoClass.getAnnotation(Tables.class);
        if (annotation!=null) {
            //do something 业务操作
            System.out.println(annotation);
            System.out.println(annotation.name());
        }

    }
    //获取有哪些注解
    public static void getAnnoOfClass(){
        Class<?> testAnnoClass = TestAnno.class;
        Annotation[] annotations = testAnnoClass.getAnnotations();
        for (Annotation an:
                annotations) {
            System.out.println(an);
        }
    }
}
