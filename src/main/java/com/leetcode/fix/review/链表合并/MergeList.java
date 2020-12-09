package com.leetcode.fix.review.链表合并;

public class MergeList {
    static class ListNodeMerge{
        int value;
        ListNodeMerge next;
        ListNodeMerge(int value) {
            this.value = value;
        }
        ListNodeMerge() {
        }
    }

    public static void main(String[] args) {

        ListNodeMerge head1 = new ListNodeMerge(0);
        ListNodeMerge l1 = new ListNodeMerge(2);
        head1.next = l1;
        ListNodeMerge l2 = new ListNodeMerge(5);
        l1.next = l2;
        ListNodeMerge l3 = new ListNodeMerge(7);
        l2.next = l3;

        ListNodeMerge head2 = new ListNodeMerge(1);
        ListNodeMerge l4 = new ListNodeMerge(3);
        head2.next = l4;
        ListNodeMerge l5 = new ListNodeMerge(4);
        l4.next = l5;
        ListNodeMerge l6 = new ListNodeMerge(10);
        l5.next = l6;


        ListNodeMerge rest = merge(head1,head2);
        while (rest != null) {
            System.out.println(rest.value);
            rest = rest.next;
        }
    }

    private static ListNodeMerge merge(ListNodeMerge head1, ListNodeMerge head2) {

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.value <= head2.value) {
            head1.next = merge(head1.next,head2);
            return head1;
        } else {
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }
}
