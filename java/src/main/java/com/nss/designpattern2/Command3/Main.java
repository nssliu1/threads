package com.nss.designpattern2.Command3;

import com.nss.designpattern2.Command3.greens.Greens;
import com.nss.designpattern2.Command3.howtocook.RestartToCook;
import com.nss.designpattern2.Command3.howtocook.StartToCook;
import com.nss.designpattern2.Command3.howtocook.StopToCook;
import com.nss.designpattern2.Command3.menuandhowtodo.MenuAndHowToDo;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 9:08
 * @describe:
 */
public class Main {
    public static void main(String[] args) {
        MenuAndHowToDo menuAndHowToDo = new MenuAndHowToDo();

        StartToCook startxhs = new StartToCook(new Greens("xhs"));
        StopToCook stopxhs = new StopToCook(new Greens("xhs1"));
        RestartToCook restartxhs = new RestartToCook(new Greens("xhs2"));

        menuAndHowToDo.addGreens(startxhs);
        menuAndHowToDo.addGreens(stopxhs);
        menuAndHowToDo.addGreens(restartxhs);
        menuAndHowToDo.execute();
    }
}
