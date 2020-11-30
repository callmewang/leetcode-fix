package com.leetcode.fix.tree;

public class Leetcode129 {

    static int sum = 0;
    public static void main(String[] args) {



    }

    public static int sumNumbers(TreeNode root) {
        leafVal(0,root);
        return sum;

    }

    private static void leafVal(int val ,TreeNode leaf) {
        if (leaf == null ) return ;
        val = val*10 + leaf.val;
        if (leaf.left == null && leaf.right == null) {
            sum += val;
        }
        leafVal(val,leaf.left);
        leafVal(val,leaf.right);
    }
}
