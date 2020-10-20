package com.leetcode.fix.arrray;

import java.util.Arrays;

/*
* number 3 矩阵顺时针旋转
* */
public class Offer29 {

    public static void main(String[] args){

        int[][] a = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        int[] r = spiralOrder(a);
        System.out.println(Arrays.toString(r));


    }

    public static int[] spiralOrder(int[][] array){
        int hang = array.length - 1;
        int lie = array[0].length - 1;

        int[] rest = new int[(hang+1) * (lie+1)];
        int index = 0;

        int hanghigh = hang;
        int liehigh = lie;
        int hanglow = 0;
        int lielow = 0;
        while(hanglow <= hanghigh && lielow < liehigh){
            int hangIndex = hanglow;
            int lieIndex = lielow;
            while (lieIndex < liehigh) {
                rest[index] = array[hangIndex][lieIndex];
                index++;
                lieIndex++;
            }
            hanglow++;

            while (hangIndex < hanghigh) {
                rest[index] = array[hangIndex][lieIndex];
                index++;
                hangIndex++;
            }
            liehigh--;

            while (lieIndex > lielow) {
                rest[index] = array[hangIndex][lieIndex];
                index++;
                lieIndex--;
            }
            hanghigh--;
            while (hangIndex > hanglow) {
                rest[index] = array[hangIndex][lieIndex];
                index++;
                hangIndex--;
            }
        }
        return rest;
    }
}
