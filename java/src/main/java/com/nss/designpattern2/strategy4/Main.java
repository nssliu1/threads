package com.nss.designpattern2.strategy4;

import com.nss.designpattern2.strategy4.context.Context;
import com.nss.designpattern2.strategy4.strategy.CommandLinux;
import com.nss.designpattern2.strategy4.strategy.CommandWindows;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 10:21
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        String name = "linux";
        if(name.equals("linux")){
            context.setCommand(new CommandLinux());
        }else if(name.equals("windows")){
            context.setCommand(new CommandWindows());
        }
        context.execute();
    }
}
