package com.leetcode.fix.list;

import java.util.List;
/*
* number 4
* */
public class LeetCode328 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode result = oddEvenList(head);
        System.out.println(result);
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null) return head;
        ListNode firstHead = head;
        ListNode secondHead = head.next;

        while (secondHead != null &&secondHead.next!=null) {
            ListNode first =  secondHead.next;
            ListNode second = first.next;

            ListNode p =  firstHead.next;
            firstHead.next = first;
            first.next = p;

            secondHead.next = null;
            secondHead.next = second;

            firstHead = first;
            secondHead = second;

        }
        return head;
    }
}
