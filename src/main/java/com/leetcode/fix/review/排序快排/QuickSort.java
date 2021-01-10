package com.leetcode.fix.review.排序快排;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] array = {1,6,2,4,9,1,10,8};
        qq(array,0,array.length-1);

        for (int e : array) {
            System.out.println(e);
        }

    }

    private static void quick(int[] arr,int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int key = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        quick(arr,left,l-1);
        quick(arr,r+1,right);
    }

    public static void q(int[] array,int left,int right){
        if (left > right) return;
        int l = left;
        int r = right;
        int target = array[l];
        while (l<r){
            while (l<r && array[r] >= target) {
                r--;
            }
            array[l] = array[r];
            while (l<r && array[l] <= target) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = target;

        q(array,left,l-1);
        q(array,r+1,right);

    }


    public static void qq(int[] array,int left,int right){
        if (left > right) return;
        int l = left;
        int r = right;
        int target = array[l];
        while (l<r) {
            while (l<r && array[r] >= target) {
                r--;
            }
            array[l] = array[r];
            while (l<r && array[l] <= target) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = target;

        qq(array,left,l-1);
        qq(array,r+1,right);
    }

    public static void qqq(int[] array,int left,int right){
        if (left > right) return;
        int l = left;
        int r = right;
        int target = array[l];
        while (l < r) {
            while (l<r && array[r] >= target) {
                r--;
            }
            array[l] = array[r];

            while (l<r && array[l] <= target) {
                l++;
            }
            array[r] = array[l];

        }
        array[l] = target;
        qqq(array,left,l-1);
        qqq(array,r+1,right);
    }

}
