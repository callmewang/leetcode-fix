package com.leetcode.fix.review.数组第二大值;

public class ArrayMax2 {

    public static void main(String[] args) {
        int[] target = {1,4,6,2,9,10,8,11};

        int sec = second(target);

        System.out.println(sec);


    }

    private static int second(int[] target) {

        int max = 0;
        int second = 0;
        for (int t : target) {
            second = Math.max(second,t);
            if (max < second) {
                int temp = second;
                second = max;
                max = temp;
            }
        }
        return second;
    }
}
