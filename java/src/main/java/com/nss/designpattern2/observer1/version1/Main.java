package com.nss.designpattern2.observer1.version1;
/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/10/25 9:18
 * @describe:
 */
public class Main {
    public static void main(String[] args) {

        TheObservered theObservered = new TheObservered();
        Observered observered1 = new Observered();
        Observered observered2 = new Observered();
        theObservered.registObserver(observered1);
        theObservered.registObserver(observered2);
        theObservered.updateData(2);

    }
}
