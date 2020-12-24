package com.leetcode.fix.review.最大不连续串;


public class MaxLength {
    public static void main(String[] args) {
        System.out.println(maxLength(" "));
    }

    private static int maxLength(String s) {

        int[] position = new int[128];
        for (int t =0;t<128;t++) {
            position[t] = -1;
        }

        int start = 0;
        int length = 0;

        for (int i=0;i<s.length();i++) {
            int c = s.charAt(i) ;
            start = Math.max(start,position[c] + 1);
            length = Math.max(length,i-start + 1);
            position[c] = i;
        }
        return length;
    }
}
