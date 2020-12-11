package com.leetcode.fix.arrray;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* number 7
* */
public class Leetcode128 {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2,10,5,9,8};
        System.out.println(longestConsecutive(a));
    }


    public static int longestConsecutive(int[] nums) {
        Set<Integer> number = new HashSet<>();
        for (Integer num : nums) {
            number.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (number.remove(num)) {
                int subLength = 1;
                int temp = num;
                while(number.remove(temp-1))temp--;
                subLength += (num - temp);
                temp = num;
                while(number.remove(temp+1))temp++;
                subLength+= (temp - num);
                longest = Math.max(longest,subLength);
            }
        }
        return longest;
    }
}
