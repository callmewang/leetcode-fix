package com.leetcode.fix.review.链表合并;

import com.google.common.collect.Lists;
import com.leetcode.fix.list.ListNode;

import java.util.*;

public class MergeKList {

    static class ListNodeK{
        int val;
        ListNodeK next;

        public ListNodeK(int i) {
            this.val = i;
        }

        public ListNodeK() {

        }
    }

    public static void main(String[] args) {

        PriorityQueue<ListNodeK> queue = new PriorityQueue<>(new Comparator<ListNodeK>() {
            @Override
            public int compare(ListNodeK o1, ListNodeK o2) {
                return o1.val - o2.val;
            }
        });

        ListNodeK head0 = new ListNodeK(1);
        ListNodeK l2 = new ListNodeK(2);
        head0.next = l2;
        ListNodeK l3 = new ListNodeK(4);
        l2.next = l3;

        ListNodeK head1 = new ListNodeK(2);

        ListNodeK head2 = new ListNodeK(3);
        ListNodeK l4 = new ListNodeK(10);
        head2.next = l4;

        ListNodeK head3 = new ListNodeK(7);
        ListNodeK l5 = new ListNodeK(9);
        head3.next = l5;

        List<ListNodeK> original =
                Lists.newArrayList(new ListNodeK[]{head0, head1, head2, head3});
        original.forEach(e->{
            while (e!=null) {
                queue.add(e);
                e = e.next;
            }
        });

        ListNodeK head = new ListNodeK();
        ListNodeK pre = head;
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
        }

        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
