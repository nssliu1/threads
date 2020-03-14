package com.nss.designpattern2.Command3.howtocook;

import com.nss.designpattern2.Command3.greens.Greens;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/12/30 8:59
 * @describe:
 */
public class RestartToCook implements HowToCook {
    private Greens greens;

    public RestartToCook(Greens greens) {
        this.greens = greens;
    }

    @Override
    public void execute() {
        greens.restart();
    }
}
