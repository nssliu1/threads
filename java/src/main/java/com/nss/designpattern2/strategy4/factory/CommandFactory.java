package com.nss.designpattern2.strategy4.factory;

import com.nss.designpattern2.strategy4.strategy.Command;
import com.nss.designpattern2.strategy4.strategy.CommandLinux;
import com.nss.designpattern2.strategy4.strategy.CommandWindows;
import com.sun.deploy.util.StringUtils;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 10:38
 * @describe:
 */
public class CommandFactory {
    public Command getCommand(String commandName){
        if(commandName !=null || commandName != ""){
            if(commandName.equals("CommandLinux")){
                return new CommandLinux();
            }else if(commandName.equals("CommandWindows")){
                return new CommandWindows();
            }
        }else {
            throw new RuntimeException();
        }
        return null;
    }
}
