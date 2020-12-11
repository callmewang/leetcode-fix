package com.leetcode.fix.review.树求给定值路径;

import com.leetcode.fix.review.树左视图右视图.LeftRightView;

import java.util.ArrayList;
import java.util.List;

public class FindPath {
    static class TreeNodePath {
        int value;
        TreeNodePath left;
        TreeNodePath right;

        TreeNodePath(int i) {
            this.value = i;
        }
    }


    //TODO
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

        pathSum(root,7);
        System.out.println(ans);

    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNodePath root, int sum) {
        dfs(root, sum, 0, new ArrayList<>());
        return ans;
    }

    public static void dfs(TreeNodePath root, int sum, int value, List<Integer> list) {
        if (root == null) return;
        list.add(root.value);
        if (sum == value + root.value && root.left == null && root.right == null)
            ans.add(new ArrayList<>(list));
        dfs(root.left, sum, value + root.value, list);
        dfs(root.right, sum, value + root.value, list);
        list.remove(list.size() - 1);
    }
}
