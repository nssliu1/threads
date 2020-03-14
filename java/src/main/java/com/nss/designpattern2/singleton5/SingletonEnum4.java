package com.nss.designpattern2.singleton5;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 16:16
 * @describe:
 */
public enum SingletonEnum4 {
    INSTANCE;
    private User user;
    private SingletonEnum4(){
        user = new User();
    }
    public User getInstance(){
        return user;
    }
}
