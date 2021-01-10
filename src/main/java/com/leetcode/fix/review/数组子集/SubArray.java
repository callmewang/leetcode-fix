package com.leetcode.fix.review.数组子集;


import java.util.ArrayList;
import java.util.List;

public class SubArray {

    public static void main(String[] args) {
        int[] array = {1,4};
        List<List<Integer>> rest = subArray(array);
        System.out.println(rest);

    }

    private static List<List<Integer>> subArray(int[] array) {

        List<List<Integer>> rest = new ArrayList<>();
        rest.add(new ArrayList<>());
        for (int t : array) {
            int size = rest.size();
            for (int i=0;i<size;i++) {
                List<Integer> re = new ArrayList<>(rest.get(i));
                re.add(t);
                rest.add(re);
            }
        }
        return rest;
    }


    private static List<List<Integer>> subArray2(int[] array) {

        List<List<Integer>> rest = new ArrayList<>();
        rest.add(new ArrayList<>());
       for (int t : array) {
           for (List<Integer> l : rest) {
               List<Integer> record = new ArrayList<>(l);
               record.add(t);
               rest.add(record);
           }
       }
        return rest;
    }


}
