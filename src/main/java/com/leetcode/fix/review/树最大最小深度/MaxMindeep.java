package com.leetcode.fix.review.树最大最小深度;

import com.leetcode.fix.review.树左视图右视图.LeftRightView;

public class MaxMindeep {

    static class TreeNodeDeep{
        int value;
        TreeNodeDeep left;
        TreeNodeDeep right;

        public TreeNodeDeep(int i) {
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodeDeep root = new TreeNodeDeep(1);

        TreeNodeDeep l1 = new TreeNodeDeep(2);
//        TreeNodeDeep r1 = new TreeNodeDeep(3);
        root.left = l1;
//        root.right = r1;
        TreeNodeDeep ll2 = new TreeNodeDeep(4);
        TreeNodeDeep lr2 = new TreeNodeDeep(5);
        l1.left = ll2;
//        l1.right = lr2;
//        TreeNodeDeep rl2 = new TreeNodeDeep(6);
//        TreeNodeDeep rr2 = new TreeNodeDeep(7);
//        r1.left = rl2;
//        r1.right = rr2;
        int max = maxDeep(root);
        int min = minDeep(root);
        System.out.println(max);
        System.out.println(min);

    }

    private static int minDeep(TreeNodeDeep root) {
        if (root == null) return 0;
        int deep = Math.min(minDeep(root.left),minDeep(root.right)) + 1;
        return deep;
    }

    private static int maxDeep(TreeNodeDeep root) {
        if (root == null) return 0;
        int deep = Math.max(maxDeep(root.left),maxDeep(root.right)) + 1;
        return deep;
    }


}
