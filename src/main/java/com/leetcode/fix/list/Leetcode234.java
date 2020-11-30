package com.leetcode.fix.list;

import java.util.ArrayList;
import java.util.List;

/**
 * number 13
 * */
public class Leetcode234 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        System.out.println(isPalindrome(node1));


    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<ListNode> rest  = new ArrayList<>();
        while (head != null) {
            rest.add(head);
            head = head.next;
        }
        int start = 0;
        for (int t = rest.size()-1 ;t >(rest.size()-1)/2;t--) {
            if (rest.get(start).val == rest.get(t).val){
                start++;
            } else {
                return false;
            }
        }

        return true;
    }
}
