package com.leetcode.fix.review.斐波那契数列;

public class FibList {

    // 1 1 2 3 5 8 13 21 34 55 89
    // 89
    public static void main(String[] args) {
//        int rest = fiblist(10);
        int rest2 = fiblist2(10);
//        System.out.println(rest);
        System.out.println(rest2);
    }

    private static int fiblist2(int i) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int t = 1; t<=i;t++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int fiblist(int i) {
        if (i==1 || i==2) return 1;
        int t =  fiblist(i-1) + fiblist(i-2);
        return t;
    }



}
