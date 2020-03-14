package com.nss.java1.annotation7;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 11:40
 * @describe:
 */
@Inherited
@Target(ElementType.TYPE)
@Documented
public @interface Book
{
    String name();
    String publishDate();
    String author();
}
