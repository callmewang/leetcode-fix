package com.leetcode.fix.arrray;

/**
 * number 11
 * */
public class Leetcode79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        exist(board,"ASAD");



    }

    public static boolean exist(char[][] board, String word) {
        int  w = 0;
        while (w < word.length()) {

        }
        return w == word.length()-1;
    }

    public static void dfs(){}
}
