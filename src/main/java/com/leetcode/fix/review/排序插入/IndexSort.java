package com.leetcode.fix.review.排序插入;

public class IndexSort {

    public static void main(String[] args) {
        int[] array = {1,6,2,4,9,1,10,8};
        sort(array);

        for (int e : array) {
            System.out.println(e);
        }
    }

//    private static void index(int[] array) {
//        for (int i=1;i<array.length;i++) {
//            int leftIndex = i-1;
//            int temp = array[i];
//            while (leftIndex >=0 && array[leftIndex] > temp) {
//                array[leftIndex+1] = array[leftIndex];
//                leftIndex--;
//            }
//            array[leftIndex+1] = temp;
//        }
//    }


    public static void sort(int[] array) {
        for (int i = 1;i < array.length; i++) {
            int leftIndex = i-1;
            int temp = array[i];
            while (leftIndex >= 0 && array[leftIndex] > temp) {
                array[leftIndex+1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex+1] = temp;

        }
    }
}
