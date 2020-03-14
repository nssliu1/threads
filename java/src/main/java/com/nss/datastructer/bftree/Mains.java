package com.nss.datastructer.bftree;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/2 13:37
 * @describe:
 */
public class Mains {
    public static void main(String[] args) {

        BFTree bfTree = new BFTree();
        bfTree.addData(10);
        bfTree.addData(5);
        bfTree.addData(4);
        bfTree.addData(6);
        bfTree.addData(3);
        bfTree.addData(48);
        bfTree.addData(32);
        //bfTree.print();
        //bfTree.printBt();
        /*bfTree.reMin();
        //bfTree.printBt();
        bfTree.reMax();
        bfTree.printBt();*/

        bfTree.remove(6);
        bfTree.printBt();

    }
}
