package com.leetcode.fix.review.树根节点到叶子节点之和;

public class NumberSum {

    static class TreeNodeNum{
        int value;
        TreeNodeNum left;
        TreeNodeNum right;
        TreeNodeNum(int i){
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodeNum root = new TreeNodeNum(4);

        TreeNodeNum l1 = new TreeNodeNum(9);
        TreeNodeNum r1 = new TreeNodeNum(0);
        root.left = l1;
        root.right = r1;
        TreeNodeNum l2 = new TreeNodeNum(5);
        TreeNodeNum r2 = new TreeNodeNum(1);
        l1.left = l2;
        l1.right = r2;

        int rest = dfs(root,0);
        System.out.println(rest);

        int rest1 = sum(root,0);
        System.out.println(rest1);

        int rest2 = maxVal(root,0);
        System.out.println(rest2);

    }

    private static int dfs(TreeNodeNum root,int i) {
        if (root == null) return 0;
        i = i*10 + root.value;
        if (root.left == null && root.right == null) return i;
        return dfs(root.left,i) + dfs(root.right,i);

    }

    private static int sum(TreeNodeNum root,int i){
        if (root == null )return 0;
        i = root.value + i;
        if (root.left == null && root.right ==null) return i;
        return Math.min(sum(root.left,i),sum(root.right,i));
    }

    private static int maxVal(TreeNodeNum root,int i){
        if (root == null )return 0;
        i = root.value + i*10;
        if (root.left == null && root.right ==null) return i;
        return Math.min(maxVal(root.left,i),maxVal(root.right,i));
    }


}
