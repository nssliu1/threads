package com.nss.datastructer.bftree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/2/29 18:43
 * @describe:都抽象成二叉树，二叉树的子节点抽象为子树的根节点
 */
public class BFTree {
    private BFTreeNode bfTreeNode;
    private Stack<BFTreeNode> stack;
    private Queue<BFTreeNode> queue = new LinkedList<>();
    public void addData(Integer data){
        this.bfTreeNode = add(this.bfTreeNode,data);
    }
    public void print(){
        printx(this.bfTreeNode);
    }
    public void printBt(){
        breadth(this.bfTreeNode);
    }
    public void reMin(){
        this.bfTreeNode = removeMin(this.bfTreeNode);
    }
    public void reMax(){
        this.bfTreeNode = removeMax(this.bfTreeNode);
    }
    public void remove(Integer data){
        this.bfTreeNode = removeSome(this.bfTreeNode, data);

    }
    private BFTreeNode add(BFTreeNode root,Integer data){
        if(root == null){
            root = new BFTreeNode();
            root.setData(data);
            return root;
        }else{
            if(data < root.getData()){
                root.setLeft(add(root.getLeft(),data));
            }else
            if(data > root.getData()){
                root.setRight(add(root.getRight(),data));
            }else
            if(data == root.getData()){
                root.setData(root.getData()*2);
            }
            return root;
        }

    }

    private void printx(BFTreeNode root){
        if(root==null){
            return;

        }else {
            //打印root的左子树
            printx(root.getLeft());
            //打印值 中序遍历
            System.out.println(root.getData());

            //打印右子树
            printx(root.getRight());
        }
    }

    /**
     * 通过使用队列维持入队的顺序和下一级遍历的关系
     * @param root
     */
    private void breadth(BFTreeNode root){

        queue.offer(root);

        while (!queue.isEmpty()){
            BFTreeNode bt = queue.poll();
            System.out.println(bt.getData());
            if(bt.getLeft()!=null){
                //breadth(bt.getLeft());
                queue.offer(bt.getLeft());
            }
            if(bt.getRight()!=null){
                //breadth(bt.getRight());
                queue.offer(bt.getRight());
            }
            //queue.poll();
        }

    }

    /*private BFTreeNode removeNode(BFTreeNode root,Integer data){
        if(root == null){
            return null;
        }
        if(root.getData().equals(data)){
            return
        }
        if(root.getLeft()!=null){
            removeNode(root.getLeft(),data);
        }
        if(root.getRight()!=null){
            removeNode(root.getRight(),data);
        }

    }*/

    private BFTreeNode removeMin(BFTreeNode root){
        if(root == null){
            return null;
        }
        if(root.getLeft()!=null){
            root.setLeft(removeMin(root.getLeft()));
            return root;
        }else{
            return root.getRight();
        }
    }

    private BFTreeNode removeMax(BFTreeNode root){
        if(root == null){
            return null;
        }
        if(root.getRight()!=null){//右子树根节点可能变化，所以要将左子树节点返回
            root.setRight(removeMax(root.getRight()));
            return bfTreeNode;
        }else {
            return root.getLeft();
        }
    }

    private BFTreeNode findMinVal(BFTreeNode root){
        if(root == null){
            return null;
        }else{
            if(root.getLeft()==null){
                return root;
            }else {
                return findMinVal(root.getLeft());
            }
        }
    }
    private BFTreeNode removeSome(BFTreeNode root,Integer data){
        if(root == null){
            return null;
        }else{
            if(root.getData()>data){
                BFTreeNode bfTreeNode = removeSome(root.getLeft(), data);
                root.setLeft(bfTreeNode);
                return root;
            }else if(root.getData()<data){

                BFTreeNode bfTreeNode = removeSome(root.getRight(), data);
                root.setRight(bfTreeNode);
                return root;
            }else{
                if(root.getLeft()==null){
                    BFTreeNode bfTreeNode = removeMin(root);
                    return bfTreeNode;
                }
                if(root.getRight()==null){
                    BFTreeNode bfTreeNode = removeMax(root);
                    return bfTreeNode;
                }

                BFTreeNode rmNode = findMinVal(root.getRight());
                BFTreeNode newNode = new BFTreeNode();
                newNode.setData(rmNode.getData());
                removeMin(root.getRight());
                newNode.setLeft(root.getLeft());
                newNode.setRight(root.getRight());
                root.setLeft(null);
                root.setRight(null);
                root.setData(null);
                return newNode;

            }
        }
    }
}
