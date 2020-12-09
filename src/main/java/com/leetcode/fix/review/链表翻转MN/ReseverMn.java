package com.leetcode.fix.review.链表翻转MN;

import com.leetcode.fix.list.ListNode;
import com.leetcode.fix.review.单链表是否有环环入口.ListCircle;
import com.leetcode.fix.review.链表翻转.ReverseList;

public class ReseverMn {

    static class ListNodeMn{
        int value;
        ListNodeMn next;
    }

    public static void main(String[] args) {
        ListNodeMn n0 = new ListNodeMn();
        n0.value = 1;
        ListNodeMn n1 = new ListNodeMn();
        n0.next = n1;
        n1.value = 2;
        ListNodeMn n2 = new ListNodeMn();
        n1.next = n2;
        n2.value = 3;
        ListNodeMn n3 = new ListNodeMn();
        n2.next = n3;
        n3.value = 4;
        ListNodeMn n4 = new ListNodeMn();
        n3.next = n4;
        n4.value = 5;

        ListNodeMn head = reseverMn(n0,2,4);

        while (head !=null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static ListNodeMn reseverMn(ListNodeMn head, int m, int n) {

        ListNodeMn dumy = new ListNodeMn();
        dumy.next = head;
        ListNodeMn pre = dumy;


        for (int i=0;i<m;i++) {
            pre = pre.next;
        }
        //1->2->3->4->5->6
        //1-2-4-3-5-6
        //1-2-5-4-3-6
        head = pre.next;
        for (int t = m;t<n;t++) {
            ListNodeMn next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dumy.next;
    }
}
