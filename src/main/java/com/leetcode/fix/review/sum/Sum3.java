package com.leetcode.fix.review.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3 {

    public static void main(String[] args) {
        int[]  nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> rest = sum3(nums);
    }

    private static List<List<Integer>> sum3(int[] nums) {
        List<List<Integer>> rest = new ArrayList<>();
        for (int i = 0;i<nums.length;i++) {
            List<List<Integer>> rr = sum2(nums,0-nums[i],i);
            rest.addAll(rr);
        }
        return rest;
    }

    public static List<List<Integer>>sum2(int[] nums,int target,int index){

        List<List<Integer>> rest = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<nums.length;i++) {
            if (i == index) continue;
            if (map.containsKey(nums[i])) {
                List<Integer> r = new ArrayList<>();
                r.add(nums[index]);
                r.add(nums[i]);
                r.add(map.get(nums[i]));
                boolean f = false;
                for (List<Integer> e : rest) {
                    f = e.containsAll(r);
                    if (f) break;
                }
                if (!f) rest.add(r);

            } else {
                int val = target - nums[i];
                map.put(val,nums[i]);
            }
        }
        return rest;
    }
}
