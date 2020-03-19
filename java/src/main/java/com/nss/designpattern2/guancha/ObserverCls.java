package com.nss.designpattern2.guancha;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/19 12:53
 * @describe:
 */
public class ObserverCls implements Observer{
    Map<String,Thread> tasks = new HashMap<>();
    @Override
    public void updateTask(Map<String, Thread> tasks) {
        this.tasks = tasks;
    }
}
