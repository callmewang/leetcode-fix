package com.leetcode.fix.review.最大不连续串;

import java.util.HashMap;
import java.util.Map;

public class MaxStr {

    public static void main(String[] args) {
        String rest = maxStr("abcdabce");
        System.out.println(rest);
    }

    private static String maxStr(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int maxLen = 0;
        int len = 0;
        int start = 0;
        int subStart = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<s.length();i++) {
            int c = s.charAt(i);

            if (map.containsKey(c)) {
                int temp = map.get(c);
                start = temp+1;
                map = new HashMap<>();
                len=0;
                i = temp;
            } else {
                map.put(c,i);
                len++;
                if (len > maxLen) {
                    maxLen = len;
                    subStart = start;
                }
            }
        }

        return s.substring(subStart,subStart+maxLen);
    }


}
