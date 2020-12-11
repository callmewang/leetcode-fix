package com.leetcode.fix.review.树先中后序遍历;

import com.leetcode.fix.review.树层序遍历.TreeLevelScan;

import java.util.*;


//TODO
public class TreeNodeList {


    static class TreeNodeF {
        int value;
        TreeNodeF left;
        TreeNodeF right;

        public TreeNodeF(int i) {
            this.value = i;

        }
    }

    public static void main(String[] args) {
        TreeNodeF root = new TreeNodeF(1);

        TreeNodeF l1 = new TreeNodeF(2);
        TreeNodeF r1 = new TreeNodeF(3);
        root.left = l1;
        root.right = r1;
        TreeNodeF ll2 = new TreeNodeF(4);
        TreeNodeF lr2 = new TreeNodeF(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodeF rl2 = new TreeNodeF(6);
        TreeNodeF rr2 = new TreeNodeF(7);
        r1.left = rl2;
        r1.right = rr2;

//        System.out.println("========first=========");
//        first(root);
//        System.out.println("========firstrecursion=========");
//        firstrecursion(root);

//        System.out.println("========mid=========");
//        mid(root);
//        System.out.println("========midrecursion=========");
//        midrecursion(root);

        System.out.println("==========last==========");
        last(root);
        System.out.println("========lastrecursion=========");
        lastrecursion(root);


    }








    private static void first(TreeNodeF root) {
        if (root == null) return;
        System.out.println(root.value);
        first(root.left);
        first(root.right);
    }
    private static void firstrecursion(TreeNodeF root) {
        Stack<TreeNodeF> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNodeF node = s.pop();
            System.out.println("----" + node.value);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

    }


    private static void mid(TreeNodeF root) {
        if (root == null) return;
        mid(root.left);
        System.out.println(root.value);
        mid(root.right);
    }

    private static void midrecursion(TreeNodeF root) {
        Stack<TreeNodeF> s = new Stack<>();
        if(root!=null) {
            while(root != null || !s.isEmpty()){
                if(root!=null) {
                    s.push(root);
                    root = root.left;
                } else{
                    root = s.pop();
                    System.out.println("----"+root.value);
                    root = root.right;
                }
            }
        }
    }
    private static void last(TreeNodeF root) {
        if (root == null) return;
        last(root.left);
        last(root.right);
        System.out.println(root.value);
    }
    private static void lastrecursion(TreeNodeF root) {

        Stack<TreeNodeF> s = new Stack<>();
        Set<TreeNodeF> seen = new HashSet<>();
        while (root != null || !s.isEmpty()) {
            if (root == null && seen.contains(s.peek())) {
                System.out.println("-----"+s.pop().value);
            } else if (root == null) {
                seen.add(s.peek());
                root = s.peek().right;
            } else {
                s.push(root);
                root = root.left;
            }
        }
    }


}
