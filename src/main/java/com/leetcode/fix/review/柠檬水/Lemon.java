package com.leetcode.fix.review.柠檬水;

import java.util.HashMap;
import java.util.Map;

public class Lemon {
    public static void main(String[] args) {
        int[] array = {5,5,5,10,20};

        int[] array2 = {5,5,10,10,20};

        System.out.println(check(array));

        System.out.println(check(array2));

    }

    public static boolean check(int[] array) {

        int five = 0;
        int ten = 0;
        for (int e : array) {
            if (e == 5) {
                five++;
            } else if (e == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (ten > 0 && five < 0 ){
                    return false;
                } else if (ten == 0 && five >=3){
                    five-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
