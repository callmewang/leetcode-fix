package com.leetcode.fix.review.树是否相同;

public class Sametree {
    static class TreeNodeSame {
        int value;
        TreeNodeSame left;
        TreeNodeSame right;
        TreeNodeSame(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNodeSame p = new TreeNodeSame(1);
        TreeNodeSame l1 = new TreeNodeSame(2);
        TreeNodeSame r1 = new TreeNodeSame(3);
        p.left = l1;
        p.right = r1;

        TreeNodeSame q = new TreeNodeSame(1);
        TreeNodeSame l2 = new TreeNodeSame(2);
        TreeNodeSame r2 = new TreeNodeSame(3);
        q.left = l2;
        q.right = r2;
        
        boolean rest = same(p,q);

        System.out.println(rest);
    }

    private static boolean same(TreeNodeSame p, TreeNodeSame q) {
        if (p == null && q==null) return true;
        if (p == null || q==null) return false;
        return p.value == q.value && same(p.left,q.left) && same(p.right,q.right);

    }
}
