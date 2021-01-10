package com.leetcode.fix.review.最长子序列;

import java.util.ArrayList;
import java.util.List;

public class MaxLen {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aa"));

    }


    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> rest = new ArrayList<>();
        if (s == null || s.length() == 0) return rest;
        char pre = s.charAt(0);
        int start = 0;
        int end = 0;
        int i = 1;
        while (i < s.length()) {

            while (i<s.length() && pre == s.charAt(i) ) {
                end++;
                i++;
            }
            if (end - start >= 2) {
                List<Integer> r = new ArrayList<>();
                r.add(start);
                r.add(end);
                rest.add(r);
            }
            if (i == s.length()) break;
            start = i;
            end = i;
            pre = s.charAt(i);
            i++;
        }


//        for (int i =0;i<s.length();i++) {
//            if (pre == s.charAt(i)){
//                start = Math.min(start,i);
//                if (i-start >= 2) end = i;
//                if (i == s.length()-1 && i-start >= 2) {
//                    List<Integer> r = new ArrayList<>();
//                    r.add(start);
//                    r.add(end);
//                    rest.add(r);
//                }
//            }
//            if (pre != s.charAt(i)) {
//                if (end -start >=2) {
//                    List<Integer> r = new ArrayList<>();
//                    r.add(start);
//                    r.add(end);
//                    rest.add(r);
//                }
//                start = i;
//                end = i;
//                pre = s.charAt(i);
//            }
//
//        }
        return rest;

    }
}
