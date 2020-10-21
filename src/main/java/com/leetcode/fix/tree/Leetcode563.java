package com.leetcode.fix.tree;

/*
* number 9
* */
public class Leetcode563 {
    //4,2,9,3,5,null,7] 6+2+7
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(9);

        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(5);

        TreeNode rr = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = ll;
        left.right = lr;
        right.left = null;
        right.right = rr;
        System.out.println(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        if(root == null) return 0;
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    public static int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
