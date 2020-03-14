package com.nss.designpattern2.strategy4.context;

import com.nss.designpattern2.strategy4.strategy.Command;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 10:19
 * @describe:
 */
public class Context {
    private Command command;

    public Context() {
    }

    public Context(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
