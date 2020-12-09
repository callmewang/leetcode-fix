package com.leetcode.fix.review.链表相加;

public class ListSum {

    static class ListNodeSum {
        int value;
        ListNodeSum next;
        ListNodeSum(int value){
            this.value = value;
        }

        public ListNodeSum() {

        }
    }

    public static void main(String[] args) {
        //716 592
        ListNodeSum l0 = new ListNodeSum(7);
        ListNodeSum l1 = new ListNodeSum(1);
        l0.next = l1;
        ListNodeSum l2 = new ListNodeSum(6);
        l1.next = l2;

        ListNodeSum n0 = new ListNodeSum(5);
        ListNodeSum n1 = new ListNodeSum(9);
        n0.next = n1;
        ListNodeSum n2 = new ListNodeSum(2);
        n1.next = n2;
        ListNodeSum head = sum(l0,n0);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static ListNodeSum sum(ListNodeSum l0, ListNodeSum n0) {
        ListNodeSum head = new ListNodeSum();
        ListNodeSum pre = head;
        int capty = 0;
        while (l0 != null || n0 != null) {
            int value = (l0 == null?0:l0.value) + (n0 == null?0:n0.value) + capty;
            int current = value%10;
            ListNodeSum node = new ListNodeSum(current);
            head.next = node;
            head = node;
            capty = value/10;

            if (l0 != null) l0 = l0.next;
            if (n0 != null) n0 = n0.next;
        }

        if (capty != 0) {
            head.next = new ListNodeSum(capty);
        }
        return pre.next;
    }


}
