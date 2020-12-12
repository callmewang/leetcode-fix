package com.leetcode.fix.review.Dota投票;

import java.util.Stack;

public class DotaApply {

    //TODO
    public static void main(String[] args) {

        String a = "DR";
        String rest = predictPartyVictory(a);
        System.out.println(rest);
    }


    public static String predictPartyVictory(String senate) {

        Stack<Character> stack = new Stack<>();
        char first = 'D' ;
        for (int i = 0;i <senate.length();i++) {
            char a = senate.charAt(i);

            if (stack.isEmpty()) {
                first = a;
                stack.push(a);
            } else {
                char top = stack.peek();
                stack.push(a);
                if (top != a) {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        String rest = stack.isEmpty() ? first+"":stack.pop().toString();
        return "D".equals(rest) ? "Dire" : "Radiant";
    }

}
