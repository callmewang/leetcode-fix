package com.leetcode.fix.review.树左视图右视图;

import com.leetcode.fix.review.单链表是否有环环入口.ListCircle;
import com.leetcode.fix.review.树层序遍历.TreeLevelScan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftRightView {
    static class TreeNodeView{
        int value;
        TreeNodeView left;
        TreeNodeView right;
        public TreeNodeView(int i) {
            this.value = i;
        }
    }
    public static void main(String[] args) {
        TreeNodeView root = new TreeNodeView(1);

        TreeNodeView l1 = new TreeNodeView(2);
        TreeNodeView r1 = new TreeNodeView(3);
        root.left = l1;
        root.right = r1;
        TreeNodeView ll2 = new TreeNodeView(4);
        TreeNodeView lr2 = new TreeNodeView(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodeView rl2 = new TreeNodeView(6);
        TreeNodeView rr2 = new TreeNodeView(7);
        r1.left = rl2;
        r1.right = rr2;

        List<List<Integer>> rest = view(root);

        //left
        List<Integer> left = new ArrayList<>();
        for (List<Integer> e : rest) {
            if (e != null && e.size() > 0) {
                left.add(e.get(0));
            }
        }
        System.out.println(left);

        //right
        List<Integer> right = new ArrayList<>();
        for (List<Integer> e : rest) {
            if (e != null && e.size() > 0) {
                right.add(e.get(e.size()-1));
            }
        }

        System.out.println(right);




    }

    private static List<List<Integer>> view(TreeNodeView root) {
        List<List<Integer>> rest = new ArrayList<>();
        if (root == null) return rest;
        Queue<TreeNodeView> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> r = new ArrayList<>();
            while (count > 0 ) {
                TreeNodeView node = queue.poll();
                r.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            rest.add(r);
        }
        return rest;
    }
}
