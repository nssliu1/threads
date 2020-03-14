package com.nss.java1.designpattern8.adaptor1;

import javax.sql.DataSource;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:05
 * @describe:
 */
public class ConnMain {
    public static void main(String[] args) {
        DataSource ds = new ConnPool();
        //如果想加入方法呢？
    }
}
