package com.leetcode.fix.review.链表翻转;

public class ReverseList {

    static class ListNode{
        int value;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode();
        n0.value = 1;
        ListNode n1 = new ListNode();
        n0.next = n1;
        n1.value = 2;
        ListNode n2 = new ListNode();
        n1.next = n2;
        n2.value = 3;
        ListNode n3 = new ListNode();
        n2.next = n3;
        n3.value = 4;
        ListNode n4 = new ListNode();
        n3.next = n4;
        n4.value = 5;

        ListNode head = reserve(n0);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }

    private static ListNode reserve(ListNode n0) {
        if (n0 == null || n0.next == null) return n0;
        ListNode p = reserve(n0.next);
        n0.next.next = n0;
        n0.next = null;
        return p;
    }
}
