package com.leetcode.fix.review.树求和路径;

import com.leetcode.fix.review.树根节点到叶子节点之和.NumberSum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumPath {

   static List<List<Integer>> result = new ArrayList<>();
   static Deque<Integer> rest = new LinkedList<>();

    static class TreeNodePath{
        int value;
        TreeNodePath left;
        TreeNodePath right;
        TreeNodePath(int i){
            this.value = i;
        }
    }

    public static void main(String[] args) {
        TreeNodePath root = new TreeNodePath(4);

        TreeNodePath l1 = new TreeNodePath(9);
        TreeNodePath r1 = new TreeNodePath(0);
        root.left = l1;
        root.right = r1;
        TreeNodePath l2 = new TreeNodePath(5);
        TreeNodePath r2 = new TreeNodePath(1);
        l1.left = l2;
        l1.right = r2;

        findPath(root,14);

        System.out.println(result);

    }

    private static void findPath(TreeNodePath root, int target) {

        if (root == null) return;
        target = target-root.value;

        rest.addLast(root.value);

        if (root.left == null && root.right == null && target == 0) {
            result.add(new LinkedList<>(rest));
        }

        findPath(root.left,target);
        findPath(root.right,target);

        rest.pollLast();
    }

}
