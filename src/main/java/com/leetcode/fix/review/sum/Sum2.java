package com.leetcode.fix.review.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2 {
    public static void main(String[] args) {
        int[] array = {1,4,2,6,9,2,10,7};

        List<List<Integer>> rest = target(array,8);

    }

    private static List<List<Integer>> target(int[] array, int target) {
        List<List<Integer>> rest = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int t =0;t<array.length;t++) {
            if (map.containsKey(array[t])) {
                List<Integer> r = new ArrayList<>();
                r.add(t);
                r.add(map.get(array[t]));
                rest.add(r);
            } else {
                map.put(target-array[t],t);
            }

        }
        return rest;
    }

}
