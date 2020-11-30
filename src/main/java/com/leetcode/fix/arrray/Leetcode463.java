package com.leetcode.fix.arrray;

public class Leetcode463 {

    public static void main(String[] args) {
        int[][] grid= {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}} ;
        System.out.println(islandPerimeter(grid));
    }


    public static int islandPerimeter(int[][] grid) {
        int size = 0;

        for (int i = 0; i< grid.length;i++) {
            for (int t = 0; t< grid[i].length;t++) {
                if (grid[i][t] != 1) continue;
                //上
                if (i-1 < 0 || (i-1 >= 0 && grid[i-1][t] == 0)) {
                    size+=1;
                }
                //下
                if (i+1>=grid.length ||( i+1 < grid.length && grid[i+1][t] == 0)) {
                    size+=1;
                }
                //左
                if (t-1<0 || (t-1 >=0 && grid[i][t-1] == 0)) {
                    size+=1;
                }
                //右
                if (t+1 >=grid[i].length || (t+1 < grid[i].length && grid[i][t+1] == 0)) {
                    size+=1;
                }
            }
        }
        return size;

    }
}
