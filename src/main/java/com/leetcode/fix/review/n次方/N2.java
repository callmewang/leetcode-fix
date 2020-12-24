package com.leetcode.fix.review.n次方;

import java.util.Arrays;

public class N2 {

    public static void main(String[] args) {
        int a = 16;
        int[] array = {3,2,1,5,6,4};
        //System.out.println((a & (a-1))== 0);
        //System.out.println(findKthLargest(array,2));

        System.out.println(appendStr(4,1,new StringBuffer()));


    }

    public static int findKthLargest(int[] nums, int k) {

        int length = nums.length;
        for(int i = 0;i<k;i++) {
            for(int j=0;j<length-i-1;j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        if(k<=length) return nums[0];
        return nums[length - k];
    }

    public static String appendStr(int a,int b,StringBuffer buffer){
        if (a==0 && b ==0) return buffer.toString();

        if ( a > b) {
            if (a>=2){
                buffer.append("aa");
                a -= 2;
            } else if (a==1){
                buffer.append("a");
                a -= 1;
            }
            if (b>=2){
                buffer.append("bb");
                b -= 2;
            } else if (b==1){
                buffer.append("b");
                b -= 1;
            }
        } else {
            if (b>=2){
                buffer.append("bb");
                b -= 2;
            } else if (b==1){
                buffer.append("b");
                b -= 1;
            }
            if (a>=2){
                buffer.append("aa");
                a -= 2;
            } else if (a==1){
                buffer.append("a");
                a -= 1;
            }
        }
        return appendStr(a,b,buffer);
    }
}
