package com.leetcode.fix.review.数字反转;

public class ReseverNum {

    public static void main(String[] args) {
       int rest =  resever(-123);

    }

    private static int resever(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) return 0;
            result = result * 10 + mod;
        }
        return result;
    }

}
