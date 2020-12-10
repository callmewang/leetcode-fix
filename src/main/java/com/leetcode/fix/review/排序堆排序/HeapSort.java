package com.leetcode.fix.review.排序堆排序;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {1,6,2,4,9,1,10,8};
        for (int i = array.length/2 -1;i>=0;i--) {
            heap(array,i,array.length);
        }

        for (int j = array.length-1;j>0;j--) {
            swapInt(array,0,j);
            heap(array,0,j);
        }
        for (int e : array) {
            System.out.println(e);
        }
    }

    private static void swapInt(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void heap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2*i+1;k<length;k= k*2+1) {
            if (k+1<length && array[k] < array[k+1]) {
                k++;
            }
            if (temp < array[k]) {
                array[i] = array[k];
                i=k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }
}
