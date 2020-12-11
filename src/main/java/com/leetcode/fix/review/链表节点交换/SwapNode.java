package com.leetcode.fix.review.链表节点交换;

import com.leetcode.fix.list.ListNode;

public class SwapNode {
    static class ListNodeSwap{
        int value;
        ListNodeSwap next;
        ListNodeSwap(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNodeSwap s0 = new ListNodeSwap(1);
        ListNodeSwap s1 = new ListNodeSwap(2);
        s0.next = s1;
        ListNodeSwap s2 = new ListNodeSwap(3);
        s1.next = s2;
        ListNodeSwap s3 = new ListNodeSwap(4);
        s2.next = s3;
        ListNodeSwap s4 = new ListNodeSwap(5);
        s3.next = s4;
        ListNodeSwap s5 = new ListNodeSwap(6);
        s4.next = s5;

        ListNodeSwap rest = swap(s0);
        while (rest!=null) {
            System.out.println(rest.value);
            rest = rest.next;

        }
    }




    public static ListNodeSwap swap(ListNodeSwap head){
        if (head == null || head.next == null) return head;
        ListNodeSwap next = head.next;
        head.next = swap(next.next);
        next.next = head;
        return next;
    }

}
