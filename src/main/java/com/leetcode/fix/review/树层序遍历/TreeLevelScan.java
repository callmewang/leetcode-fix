package com.leetcode.fix.review.树层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelScan {

    static class TreeNodeLevel {
        int value;
        TreeNodeLevel left;
        TreeNodeLevel right;

        public TreeNodeLevel(int i) {
            this.value = i;

        }
    }

    public static void main(String[] args) {
        TreeNodeLevel root = new TreeNodeLevel(1);

        TreeNodeLevel l1 = new TreeNodeLevel(2);
        TreeNodeLevel r1 = new TreeNodeLevel(3);
        root.left = l1;
        root.right = r1;
        TreeNodeLevel ll2 = new TreeNodeLevel(4);
        TreeNodeLevel lr2 = new TreeNodeLevel(5);
        l1.left = ll2;
        l1.right = lr2;
        TreeNodeLevel rl2 = new TreeNodeLevel(6);
        TreeNodeLevel rr2 = new TreeNodeLevel(7);
        r1.left = rl2;
        r1.right = rr2;
        List<Integer> rest = rightSideView(root);
        rest.stream().forEach(e -> {
            System.out.println(e);
        });

    }

    private static List<List<Integer>> levelScan(TreeNodeLevel root) {
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> rest = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>();
            while (count > 0) {
                TreeNodeLevel temp = queue.poll();
                level.add(temp.value);
                if (temp.left == null && temp.right == null) {
                    last.add(temp.value);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                count--;
            }
            rest.add(level);
        }
        System.out.println(last);
        return rest;
    }

    public List<List<Integer>> leveScan(TreeLevelScan root) {
        List<List<Integer>> rest = new ArrayList<>();

        Queue<TreeNodeLevel> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> r = new ArrayList<>();
            while (count > 0) {
                TreeNodeLevel node = queue.poll();
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

    public static List<Integer> rightSideView(TreeNodeLevel root) {

        List<Integer> rest = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> r = new ArrayList<>();
            while (count > 0) {
                TreeNodeLevel node = queue.poll();
                r.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            rest.add(r.get(r.size()));

        }
        return rest;

    }

}
