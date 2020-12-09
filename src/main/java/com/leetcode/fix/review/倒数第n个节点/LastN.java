package com.leetcode.fix.review.倒数第n个节点;

import com.leetcode.fix.review.单链表是否有环环入口.ListCircle;

public class LastN {
    static class ListNodeN{
        int value;
        ListNodeN next;
    }

    public static void main(String[] args) {

        ListNodeN n0 = new ListNodeN();
        n0.value = 1;
        ListNodeN n1 = new ListNodeN();
        n0.next = n1;
        n1.value = 2;
        ListNodeN n2 = new ListNodeN();
        n1.next = n2;
        n2.value = 3;
        ListNodeN n3 = new ListNodeN();
        n2.next = n3;
        n3.value = 4;
        ListNodeN n4 = new ListNodeN();
        n3.next = n4;
        n4.value = 5;
        lastN(n0,3);
    }

    //1-2-3-4-5
    private static void lastN(ListNodeN head,int n) {
        ListNodeN p1 = head;
        ListNodeN p2 = head;
        for (int i=0;i<n;i++) {
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println(p2.value);


    }
}
