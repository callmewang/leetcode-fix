package com.leetcode.fix.review.队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {

        put(1);
        put(2);
        put(3);
        System.out.println(get());
        System.out.println(get());
        put(4);
        System.out.println(get());
        System.out.println(get());



    }

    public static void put(int t) {
        q1.offer(t);
    }

    public static int get() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int value = q1.poll();
        while (q2.size() > 0) {
            q1.offer(q2.poll());
        }
        return value;
    }

    public void putV(int i){
        q1.offer(1);
    }

    public int getV(){
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int v = q1.poll();
        while (q2.size() > 0) {
            q1.offer(q2.poll());
        }
        return v;
    }

}
