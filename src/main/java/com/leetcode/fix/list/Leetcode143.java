package com.leetcode.fix.list;

/*
* number 1
* */
public class Leetcode143 {

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        reorderList(node1);
        while(node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }

    public static void reorderList(ListNode head) {
        while(head!=null && head.next != null && head.next.next != null){
            ListNode cur = head.next;
            ListNode pre = head;
            while(cur.next != null){
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
            ListNode t = head.next;
            cur.next = t;
            head.next = cur;
            head = head.next.next;
        }
    }
}
