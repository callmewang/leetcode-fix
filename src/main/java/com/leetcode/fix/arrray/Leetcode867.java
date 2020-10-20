package com.leetcode.fix.arrray;

import java.util.Arrays;

/*
* number 6
* */
public class Leetcode867 {

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rest = transpose(A);
        System.out.println(Arrays.toString(rest));

    }

    public static int[][] transpose(int[][] A) {

        int[][] result = new int[A[0].length][A.length];

        for (int hang =0; hang < A.length;hang++) {
            for (int lie=0;lie<A[0].length;lie++) {
                result[lie][hang] = A[hang][lie];
            }
        }
        return result;
    }
}
