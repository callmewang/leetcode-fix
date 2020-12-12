package com.leetcode.fix.review.队列实现栈;

import java.util.Stack;

public class StackImpl {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {

        put(1);
        put(2);
        put(3);
        System.out.println(get());
        System.out.println(get());
        put(4);
        System.out.println(get());
        System.out.println(get());
        put(5);
        put(6);
        put(7);
        System.out.println(get());
        System.out.println(get());
        System.out.println(get());
        System.out.println(get());
    }

    public static  void put(int i){
        s1.push(i);
    }
    public static  int get(){
        if (!s2.isEmpty()) return s2.pop();

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.isEmpty() ? -1: s2.pop();
    }

}
