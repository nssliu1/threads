package com.nss.designpattern2.observer1.version1;
/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 9:18
 * @describe:
 */
public interface TheObserver {
    void registObserver(Observer observer);
    void unRegistObserver(Observer observer);
    void updateAllObserver();
    void updateData(int all);
}
