package com.leetcode.fix.review.两个链表的交点;


import com.leetcode.fix.list.ListNode;

import java.util.Stack;

public class TwoListCommon {

    static class ListNodeCommon{
        int value;
        ListNodeCommon next;

        ListNodeCommon(int value){
            this.value = value;
        }
    }


    public static void main(String[] args) {
        ListNodeCommon n0 = new ListNodeCommon(1);
        ListNodeCommon n1 = new ListNodeCommon(2);
        n0.next = n1;
        ListNodeCommon n2 = new ListNodeCommon(3);
        n1.next = n2;
        ListNodeCommon n3 = new ListNodeCommon(4);
        n2.next = n3;
        ListNodeCommon n4 = new ListNodeCommon(5);
        n3.next = n4;

        //1-2-3-4-5
        //8-9-3-4-5
        ListNodeCommon l0 = new ListNodeCommon(8);
        ListNodeCommon l1 = new ListNodeCommon(9);
        l0.next = l1;
        l1.next = n2;

        common(n0,l0);
        
    }

    private static void common(ListNodeCommon n0, ListNodeCommon l0) {
        Stack<ListNodeCommon> s1 = new Stack<>();
        Stack<ListNodeCommon> s2 = new Stack<>();
        while(n0 != null) {
            s1.push(n0);
            n0 = n0.next;
        }

        while(l0 != null) {
            s2.push(l0);
            l0 = l0.next;
        }

        ListNodeCommon common = null;

        while (s1.size() != 0 && s2.size() != 0) {
            if (s1.peek() == s2.peek()) {
                common = s1.pop();
                s2.pop();
            } else {
                break;
            }
        }
        System.out.println(common.value);
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
