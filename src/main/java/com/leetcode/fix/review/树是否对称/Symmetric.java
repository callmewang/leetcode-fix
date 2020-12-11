package com.leetcode.fix.review.树是否对称;

import com.leetcode.fix.review.树求给定值路径.FindPath;

public class Symmetric {
    static class TreeNodeSym {
        int value ;
        TreeNodeSym left;
        TreeNodeSym right;
        TreeNodeSym(int i) {
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodeSym root = new TreeNodeSym(1);

        TreeNodeSym l1 = new TreeNodeSym(2);
        TreeNodeSym r1 = new TreeNodeSym(2);
        root.left = l1;
        root.right = r1;
        TreeNodeSym ll2 = new TreeNodeSym(3);
        TreeNodeSym lr2 = new TreeNodeSym(4);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodeSym rl2 = new TreeNodeSym(4);
        TreeNodeSym rr2 = new TreeNodeSym(4);
        r1.left = rl2;
        r1.right = rr2;

        boolean rest = sym(root);
        System.out.println(rest);

    }

    private static boolean sym(TreeNodeSym root) {
        if (root == null) return true;
        return sym2(root.left,root.right);
    }

    private static boolean sym2(TreeNodeSym left, TreeNodeSym right) {
        if (left == null && right == null) return true;
        if ((left ==null && right!= null) ||(left!=null && right== null)) return false;

        return left.value==right.value
                && sym2(left.left,right.right)
                && sym2(left.right,right.left);
    }


}
