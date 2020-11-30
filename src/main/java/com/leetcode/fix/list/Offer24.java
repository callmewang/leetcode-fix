package com.leetcode.fix.list;

import java.util.List;

/**
 * number 14
*/
public class Offer24 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
