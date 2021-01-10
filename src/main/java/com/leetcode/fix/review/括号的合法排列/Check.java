package com.leetcode.fix.review.括号的合法排列;

import java.util.Stack;

public class Check {

    public static void main(String[] args) {
        String template = "";
        System.out.println(checkString(template));
        
    }

    private static boolean checkString(String template) {
        Stack<Character> s = new Stack<>();
        for (char c : template.toCharArray()) {
            if ("(".equals(c)) s.push(')');
            else if ("[".equals(c)) s.push(']');
            else if ("{".equals(c)) s.push('}');
            else if(s.isEmpty() || c != s.pop()) return false;
        }
        return s.isEmpty();
    }

}
