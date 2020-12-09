package com.leetcode.fix.review.删除链表中的重复元素;


import com.leetcode.fix.list.ListNode;

public class RemoveMultiNode {
    static class ListNodeMulti{
        int value;
        ListNodeMulti next;

        public ListNodeMulti(int i) {
            this.value = i;

        }
    }


    public static void main(String[] args) {
        ListNodeMulti head = new ListNodeMulti(1);
        ListNodeMulti n1 = new ListNodeMulti(2);
        head.next = n1;
        ListNodeMulti n2 = new ListNodeMulti(3);
        n1.next = n2;
        ListNodeMulti n3 = new ListNodeMulti(3);
        n2.next = n3;
        ListNodeMulti n4 = new ListNodeMulti(4);
        n3.next = n4;

        ListNodeMulti rest = res(head);

        while (rest != null) {
            System.out.println(rest.value);
            rest = rest.next;

        }
    }

    private static ListNodeMulti removeDump(ListNodeMulti head) {

        ListNodeMulti rList = new ListNodeMulti(0);
        rList.next = head;
        ListNodeMulti pre = rList;

        while(pre.next != null) {
            ListNodeMulti curse = pre.next;
            if(curse.next != null &&curse.value == curse.next.value) {
                while (curse.next != null &&curse.value == curse.next.value) {
                    curse = curse.next;
                }
                curse = curse.next;
                pre.next = curse;
            } else {
                pre = curse;
            }
        }

        return rList.next;
    }

    public static  ListNodeMulti res(ListNodeMulti head){
        ListNodeMulti rest = new ListNodeMulti(0);
        rest.next = head;
        ListNodeMulti pre = rest;
        while (pre.next != null) {
            ListNodeMulti cur = pre.next;
            if (cur.next!=null && cur.value == cur.next.value) {
                while(cur.next!=null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
            }
        }


        return rest.next;
    }
}
