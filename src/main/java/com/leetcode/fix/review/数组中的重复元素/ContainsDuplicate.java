package com.leetcode.fix.review.数组中的重复元素;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,1};
        System.out.println(containsDuplicate(array));
    }

    public  static  boolean containsDuplicate(int[] nums) {

        boolean rest = false;
        Set<Integer> set  = new HashSet<>();
        for (int i = 0;i<nums.length;i++) {
            boolean r = set.add(nums[i]);
            if (!r){
                rest = true;
                break;
            }
        }
        return  rest;
    }
}
