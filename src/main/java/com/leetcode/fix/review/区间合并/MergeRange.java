package com.leetcode.fix.review.区间合并;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeRange {


    //WARN
    public static void main(String[] args) {
//      int[][]  intervals = {{1,3},{2,6},{8,10},{15,18}};
      int[][]  intervals = {{1,4},{0,4}};
      int[][] rest = mergearray(intervals);
      System.out.println(1);
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i=0;i<intervals.length;i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() -1)[1] < l ) {
                merged.add(new int[]{l,r});
            } else {
                merged.get(merged.size() -1)[1] = Math.max(merged.get(merged.size() -1)[1],r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] mergearray(int[][] intervals){
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for (int i=0;i<intervals.length;i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < left) {
                merged.add(new int[]{left,right});
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);


    }
















}
