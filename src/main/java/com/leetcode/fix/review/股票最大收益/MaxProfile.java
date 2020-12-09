package com.leetcode.fix.review.股票最大收益;

public class MaxProfile {

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int maxProfile = maxProfile(price);
        System.out.println(maxProfile);

    }

    private static int maxProfile(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i=0;i<prices.length;i++) {
            min = Math.min(prices[i],min);
            max = Math.max(prices[i]-min,max);
        }
        return max;
    }
}
