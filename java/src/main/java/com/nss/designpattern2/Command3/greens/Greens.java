package com.nss.designpattern2.Command3.greens;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 8:45
 * @describe:
 */
public class Greens {
    private String command;

    public Greens(String command) {
        this.command = command;
    }
    public Greens() {
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void start(){
        System.out.println("启动"+command);
    }
    public void stop(){
        System.out.println("停止"+command);
    }
    public void restart(){
        System.out.println("重启"+command);
    }

}
