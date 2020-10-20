package com.leetcode.fix.string;

import java.util.Stack;

public class Leetcode844 {

    public  static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));

    }

    public static boolean backspaceCompare(String S, String T) {
        return fix(S).equals(fix(T));
    }

    public static String fix(String T){
        StringBuffer stringBuffer = new StringBuffer();
        char[] c = T.toCharArray();
        for (char t : c) {
            if (t == '#' && stringBuffer.length() > 0 ) {
                stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length()-1);
            } else {
                stringBuffer.append(t);
            }
        }
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

}
