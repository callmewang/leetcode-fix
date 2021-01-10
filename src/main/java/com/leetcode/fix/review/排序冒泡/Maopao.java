package com.leetcode.fix.review.排序冒泡;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;

public class Maopao {

    public static void main(String[] args) {

        int[] array = {1,6,2,4,9,1,10,8};
//        for (int i = 0;i<array.length-1;i++) {
//            for (int j=0;j<array.length-i-1;j++) {
//                if (array[j] > array[j+1]) {
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
//            }
//        }
        maopao(array);
       for (int e : array) {
           System.out.println(e);
       }
    }


    public static void maopao(int[] array) {
        for (int i=0;i<array.length-1;i++) {
            for (int j=0;j< array.length-i-1;j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void maopao2(int[] array) {
        for (int i=0;i<array.length;i++) {
            for (int j=0;j<array.length-i-1;j++) {
                if (array[j] > array[j+1]) {
                    int t = array[j+1];
                    array[j+1] = array[j];
                    array[j] = t;
                }
            }
        }
    }
}
