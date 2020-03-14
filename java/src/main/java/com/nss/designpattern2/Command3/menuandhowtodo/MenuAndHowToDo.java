package com.nss.designpattern2.Command3.menuandhowtodo;

import com.nss.designpattern2.Command3.howtocook.HowToCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 9:04
 * @describe:
 */
public class MenuAndHowToDo {
    private List<HowToCook> menu = new ArrayList<>();
    public void addGreens(HowToCook howToCook){
        menu.add(howToCook);
    }
    public void execute(){
        for (HowToCook htc:
             menu) {
            htc.execute();
        }
    }
}
