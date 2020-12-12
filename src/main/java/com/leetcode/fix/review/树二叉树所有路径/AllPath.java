package com.leetcode.fix.review.树二叉树所有路径;


import java.util.ArrayList;
import java.util.List;

public class AllPath {
    static class TreeNodePath{
        int value;
        TreeNodePath left;
        TreeNodePath right;
        TreeNodePath(int i){
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodePath root = new TreeNodePath(1);

        TreeNodePath l1 = new TreeNodePath(2);
        TreeNodePath r1 = new TreeNodePath(3);
        root.left = l1;
        root.right = r1;
        TreeNodePath ll2 = new TreeNodePath(4);
        TreeNodePath lr2 = new TreeNodePath(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodePath rl2 = new TreeNodePath(6);
        TreeNodePath rr2 = new TreeNodePath(7);
        r1.left = rl2;
        r1.right = rr2;
        printAllPath(null,new StringBuffer());
        System.out.println(re );
    }
    static List<String> re = new ArrayList<>();

    private static void printAllPath(TreeNodePath root, StringBuffer path) {
        if (root == null) return;
        path.append(root.value);
        if (root.left == null && root.right == null) {
            re.add(path.toString());
        }
        printAllPath(root.left,new StringBuffer(path).append("->"));
        printAllPath(root.right,new StringBuffer(path).append("->"));
    }

}
