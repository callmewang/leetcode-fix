package com.leetcode.fix.review.二分查找;

public class MidFind {

    public static void main(String[] args) {
        int[] array = {1,3,5,6,9,10,15,45,80,100,106};
        int rest = midFind(array,5);
        System.out.println(rest);

    }

    private static int midFind(int[] array, int target) {

        int l = 0;
        int r = array.length-1;
        while(l<r) {
            int mid = (l+r)-1 / 2;
            if (array[mid] == target) return mid;
            if (array[mid] > target) r = mid-1;
            if (array[mid] < target) l = mid+1;
        }
        return 0;
    }
}
