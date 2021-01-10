package com.leetcode.fix.review.最近公共祖先;

import com.leetcode.fix.review.树Z形遍历.ScanTreeZ;

public class CommonAnces {

    static class TreeNodeCommon {
        int value;
        TreeNodeCommon left;
        TreeNodeCommon right;

        TreeNodeCommon(int i){
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodeCommon root = new TreeNodeCommon(1);

        TreeNodeCommon l1 = new TreeNodeCommon(2);
        TreeNodeCommon r1 = new TreeNodeCommon(3);
        root.left = l1;
        root.right = r1;
        TreeNodeCommon ll2 = new TreeNodeCommon(4);
        TreeNodeCommon lr2 = new TreeNodeCommon(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodeCommon rl2 = new TreeNodeCommon(6);
        TreeNodeCommon rr2 = new TreeNodeCommon(7);
        r1.left = rl2;
        r1.right = rr2;

        TreeNodeCommon com =  common(root,ll2,rr2);
        System.out.println(com.value);
        
    }

    private static TreeNodeCommon common(TreeNodeCommon root,
                                         TreeNodeCommon p,
                                         TreeNodeCommon q) {
        if (root == null || root == p || root == q) return root;

        TreeNodeCommon left = common(root.left,p,q);
        TreeNodeCommon right = common(root.right,p,q);

        if (left != null && right != null) {
            return root;
        }

        return left==null? right:left;
    }

    private static TreeNodeCommon common2(TreeNodeCommon root,
                                         TreeNodeCommon p,
                                         TreeNodeCommon q) {

        if (root == null || root ==p || root==q) return root;

        TreeNodeCommon left = common2(root.left,p,q);
        TreeNodeCommon right = common2(root.right,p,q);
        if (left != null && right!= null) return root;
        return left==null?right:left;
    }

}
