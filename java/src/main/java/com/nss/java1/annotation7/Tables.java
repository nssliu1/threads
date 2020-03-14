package com.nss.java1.annotation7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/12 19:32
 * @describe:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Tables {
    String name() default "nss";
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface Propertys{

}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Methods{

}
