package com.nss.designpattern2.strategy4;

import com.nss.designpattern2.strategy4.context.Context;
import com.nss.designpattern2.strategy4.factory.CommandFactory;
import com.nss.designpattern2.strategy4.strategy.Command;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 10:30
 * @describe:
 */
public class Main1 {
    public static void main(String[] args) {
        Context context = new Context();
        String name = "CommandWindows";
        context.setCommand(new CommandFactory().getCommand(name));
        context.execute();
    }
}
