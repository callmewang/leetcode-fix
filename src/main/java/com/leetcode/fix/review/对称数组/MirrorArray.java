package com.leetcode.fix.review.对称数组;

public class MirrorArray {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},
                         {5,6,7,8},
                         {9,8,7,6},
                         {2,3,4,5}};

        int[][] rest = mirror(array);
        
    }

    private static int[][] mirror(int[][] array) {
        int row = array.length;

        for (int i = 0;i<row;i++) {
            for (int j =0;j<=i;j++) {
                int temp = array[j][i];
                array[j][i] = array[i][j];
                array[i][j] = temp;
            }
        }
        return array;

    }


}
