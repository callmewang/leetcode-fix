package com.leetcode.fix.review.树Z形遍历;

import com.leetcode.fix.review.树层序遍历.TreeLevelScan;

import java.util.*;

public class ScanTreeZ {
    static class ScanTreeNodeZ {
        int value;
        ScanTreeNodeZ left;
        ScanTreeNodeZ right;

        public ScanTreeNodeZ(int i) {
            this.value = i;

        }
    }

    //TODO
    public static void main(String[] args) {
        ScanTreeNodeZ root = new ScanTreeNodeZ(1);

        ScanTreeNodeZ l1 = new ScanTreeNodeZ(2);
        ScanTreeNodeZ r1 = new ScanTreeNodeZ(3);
        root.left = l1;
        root.right = r1;
        ScanTreeNodeZ ll2 = new ScanTreeNodeZ(4);
        ScanTreeNodeZ lr2 = new ScanTreeNodeZ(5);
        l1.left = ll2;
        l1.right = lr2;
        ScanTreeNodeZ rl2 = new ScanTreeNodeZ(6);
        ScanTreeNodeZ rr2 = new ScanTreeNodeZ(7);
        r1.left = rl2;
        r1.right = rr2;

        List<List<Integer>> rest = scan(root);

        rest.stream().forEach(e -> {
            System.out.println(e);
        });
    }

    private static List<List<Integer>> scan(ScanTreeNodeZ root) {
        List<List<Integer>> r = new ArrayList<>();
        LinkedList<ScanTreeNodeZ> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int deep = queue.size();
            List<Integer> level = new ArrayList<>();
            while ( count > 0 ){
                ScanTreeNodeZ node = null;
                if (deep%2 == 0) {
                    node = queue.pollFirst();
                } else {
                    node = queue.pollLast();
                }
                level.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            deep++;
            r.add(level);
        }
        return r;
    }
}
