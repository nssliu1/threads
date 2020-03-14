package com.nss.designpattern2.observer1.version2;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 9:18
 * @describe:
 */
public interface TheObserver<T> {
    void registObserver(T observer);
    void unRegistObserver(T observer);
    void updateAllObserver();
    void updateData(int all);
}
