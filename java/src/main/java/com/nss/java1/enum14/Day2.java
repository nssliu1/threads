package com.nss.java1.enum14;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/1/7 16:31
 * @describe:
 */
public enum Day2 {
    MON("周一"),
    WIN("周二");
    private String desc;

    Day2(String desc) {
        this.desc = desc;
    }
    public String getDesc(){
        return desc;
    }
}
