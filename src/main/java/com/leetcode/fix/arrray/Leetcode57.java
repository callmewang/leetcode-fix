package com.leetcode.fix.arrray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Leetcode57 {

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        insert(intervals,newInterval);

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //边界条件判断
        if (intervals.length == 0)
            return new int[][]{newInterval};
        List<int[]> resList = new ArrayList<>();
        //一个从左边开始找不重合的
        int left = 0;
        //一个从右边开始找不重合的
        int right = intervals.length - 1;

        //左边不重合的添加到list中
        while (left < intervals.length && intervals[left][1] < newInterval[0]) {
            resList.add(intervals[left++]);
        }

        //右边不重合的添加到list中
        while (right >= 0 && intervals[right][0] > newInterval[1]) {
            resList.add(left, intervals[right--]);
        }

        //下面一大坨是合并重合的，注意一些边界条件的判断
        int[] newArr = new int[2];
        if (left < intervals.length) {
            newArr[0] = Math.min(intervals[left][0], newInterval[0]);
        } else {
            newArr[0] = intervals[intervals.length - 1][1] < newInterval[0] ? newInterval[0] : Math.min(intervals[intervals.length - 1][1], newInterval[0]);
        }
        if (right < 0) {
            newArr[1] = intervals[0][0] > newInterval[1] ? newInterval[1] : Math.max(intervals[0][1], newInterval[1]);
        } else {
            newArr[1] = Math.max(intervals[right][1], newInterval[1]);
        }
        resList.add(left, newArr);

        //这一大坨是把list转二维数组
        int[][] resArr = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;

    }
}
