package com.nss.designpattern2.strategy4.strategy;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 10:19
 * @describe:
 */
public class CommandWindows implements Command {
    @Override
    public void execute() {
        System.out.println("window执行体");
    }
}
