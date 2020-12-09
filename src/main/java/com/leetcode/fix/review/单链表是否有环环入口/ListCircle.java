package com.leetcode.fix.review.单链表是否有环环入口;

import com.leetcode.fix.review.链表翻转MN.ReseverMn;

public class ListCircle {

    static class ListNodeCircle{
        int value;
        ListNodeCircle next;
    }

    public static void main(String[] args) {

        ListNodeCircle n0 = new ListNodeCircle();
        n0.value = 1;
        ListNodeCircle n1 = new ListNodeCircle();
        n0.next = n1;
        n1.value = 2;
        ListNodeCircle n2 = new ListNodeCircle();
        n1.next = n2;
        n2.value = 3;
        ListNodeCircle n3 = new ListNodeCircle();
        n2.next = n3;
        n3.value = 4;
        ListNodeCircle n4 = new ListNodeCircle();
        n3.next = n4;
        n4.value = 5;

        n4.next = n2;

        check(n0);
    }



    private static void check(ListNodeCircle head) {
        ListNodeCircle p1 = head;
        ListNodeCircle p2 = head;
        ListNodeCircle p3 = head;

        while (p1.next != null && p2.next.next != null ) {
            p1 = p1.next;
            p2 = p2.next.next;
            if ( p1 == p2) {
                break;
            }
        }
        boolean circle = !(p1==null || p2==null);
        if (p1 == p2) {
            circle = true;
        }
        System.out.println("是否有环===>" + circle);
        if (circle) {
            while (p1 != p3) {
                p1 = p1.next;
                p3 = p3.next;
            }
        }
        System.out.println(p1.value);
    }
}
