package com.leetcode.fix.review.是否为回文链表;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PalinList {
    static class PalinListNode {
        int value;
        PalinListNode next;

        public PalinListNode(int i) {
            this.value = i;
        }
    }

    public static void main(String[] args) {
        PalinListNode head = new PalinListNode(1);

        PalinListNode n0 = new PalinListNode(2);
        head.next = n0;
        PalinListNode n1 = new PalinListNode(3);
        n0.next = n1;
        PalinListNode n2 = new PalinListNode(1);
        n1.next = n2;

        boolean rest = judge(head);

        System.out.println(rest);

    }

    private static boolean judge(PalinListNode head) {
        if (head == null ) return false;
        List<PalinListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int left = 0;
        for (int t = list.size() -1;t>(list.size()-1)/2 ;t--) {
            if (list.get(left).value == list.get(t).value) {
                left++;
            } else {
                return false;
            }

        }
        return true;
    }
}
