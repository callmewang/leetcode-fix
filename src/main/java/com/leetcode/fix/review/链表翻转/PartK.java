package com.leetcode.fix.review.链表翻转;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PartK {

    static class ListNodeK {
        int val;
        ListNodeK next;
        ListNodeK(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNodeK n0 = new ListNodeK(1);
        ListNodeK n1 = new ListNodeK(2);
        n0.next = n1;
        ListNodeK n2 = new ListNodeK(3);
        n1.next = n2;
//        ListNodeK n3 = new ListNodeK(4);
//        n2.next = n3;
//        ListNodeK n4 = new ListNodeK(5);
//        n3.next = n4;
//        ListNodeK n5 = new ListNodeK(6);
//        n4.next = n5;
//        ListNodeK n6 = new ListNodeK(7);
//        n5.next = n6;
//        ListNodeK n7 = new ListNodeK(8);
//        n6.next = n7;
        
        ListNodeK rest = reseverK(n0,3);
        while (rest != null) {
            System.out.println(rest.val);
            rest = rest.next;
        }
    }

    private static ListNodeK reseverK(ListNodeK root,int k) {
        Deque<ListNodeK> pool = new LinkedList<>();
        ListNodeK rest = new ListNodeK(0);
        ListNodeK pre = rest;
        while (root != null) {
            if (pool.size() == k) {
                while (pool.size() > 0) {
                    ListNodeK node = new ListNodeK(pool.pollLast().val);
                    pre.next = node;
                    pre = node;
                }
            }
            pool.offer(root);
            root = root.next;
        }

        boolean check = pool.size() == k;

        while (pool.size() > 0) {
            ListNodeK node = null;
            if (check) {
                node = new ListNodeK(pool.pollLast().val);
            } else {
                node = new ListNodeK(pool.pollFirst().val);
            }
            pre.next = node;
            pre = node;
        }
        return rest.next;
    }
}
