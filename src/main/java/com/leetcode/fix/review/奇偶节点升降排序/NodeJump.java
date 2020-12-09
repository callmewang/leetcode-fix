package com.leetcode.fix.review.奇偶节点升降排序;

public class NodeJump {

    static class JumpNode {
        int value;
        JumpNode next;

        public JumpNode(int i) {
            this.value = i;
        }
        public JumpNode() {
        }
    }

    public static void main(String[] args) {

        JumpNode head = new JumpNode(1);
        JumpNode j1 = new JumpNode(3);
        JumpNode o1 = new JumpNode(4);
        JumpNode j2 = new JumpNode(5);
        JumpNode o2 = new JumpNode(2);
        head.next = o1;
        o1.next = j1;
        j1.next = o2;
        o2.next = j2;
        JumpNode rest = sort(head);
        while (rest != null) {
            System.out.println(rest.value);
            rest = rest.next;
        }
    }

    public static JumpNode sort(JumpNode head){
        JumpNode l1 = new JumpNode();
        JumpNode l2 = new JumpNode(); 

        JumpNode pre1 = l1;
        JumpNode pre2 = l2;


        //1-4-3-2-5
        int t = 1;
        while (head != null) {
            JumpNode node = new JumpNode(head.value);
            if (t%2 == 0) {
                pre1.next = node;
                pre1 = node;
            } else {
                pre2.next = node;
                pre2 = node;
            }
            head = head.next;
            t++;
        }
        return merge(l2.next,resever(l1.next));
    }

    private static JumpNode resever(JumpNode next) {
        if (next== null|| next.next == null) return next;
        JumpNode p = resever(next.next);
        next.next.next = next;
        next.next = null;
        return p;

    }

    private static JumpNode merge(JumpNode l1, JumpNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value <= l2.value) {
            l1.next = merge(l1.next,l2);
            return l1;
        } else {
            l2.next = merge(l1,l2.next);
            return l2;
        }


    }




}
