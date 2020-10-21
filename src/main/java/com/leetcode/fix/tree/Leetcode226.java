package com.leetcode.fix.tree;

/*
* number 10
* */
public class Leetcode226 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);

        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(9);

        root.left = left;
        root.right = right;
        left.left = ll;
        left.right = lr;
        right.left = rl;
        right.right = rr;
        invertTree(root);
        System.out.println(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = null;
        if (root.left != null) {
            temp = root.left;
        }
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
