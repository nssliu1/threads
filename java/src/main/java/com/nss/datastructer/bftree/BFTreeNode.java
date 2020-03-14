package com.nss.datastructer.bftree;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/2/29 18:40
 * @describe:
 */
public class BFTreeNode {
    private Integer data;
    private BFTreeNode left;
    private BFTreeNode right;


    public BFTreeNode() {
    }

    public BFTreeNode(Integer data, BFTreeNode left, BFTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BFTreeNode getLeft() {
        return left;
    }

    public void setLeft(BFTreeNode left) {
        this.left = left;
    }

    public BFTreeNode getRight() {
        return right;
    }

    public void setRight(BFTreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BFTreeNode bfTree = (BFTreeNode) o;

        if (data != null ? !data.equals(bfTree.data) : bfTree.data != null) return false;
        if (left != null ? !left.equals(bfTree.left) : bfTree.left != null) return false;
        return right != null ? right.equals(bfTree.right) : bfTree.right == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
