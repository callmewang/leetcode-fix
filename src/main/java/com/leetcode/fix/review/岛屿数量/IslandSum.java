package com.leetcode.fix.review.岛屿数量;

public class IslandSum {

    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0,1,0},
                       {1,1,1,0,1,0},
                       {1,0,0,1,0,0},
                       {0,1,0,0,0,1}};

        if(arr==null||arr.length==0||arr[0].length==0){
            return ;
        }
        int res=0;
        for (int i = 0;i<arr.length;i++) {
            for (int j = 0;j<arr[i].length;j++) {
                if (arr[i][j] ==0) {
                    res++;
                    change2(arr,i,j);
                }
            }
        }
        System.out.println(res);
    }

    private static void change(int[][] arr, int i, int j) {
        arr[i][j] = 0;
        //左
        if (j > 0 && arr[i][j-1] == 1) {
            change(arr,i,j-1);
        }
        //右
        if (j < arr[i].length-1 && arr[i][j+1] == 1) {
            change(arr,i,j+1);
        }
        //上
        if (i > 0 && arr[i-1][j] == 1) {
            change(arr,i-1,j);
        }
        //下
        if (i < arr.length-1 && arr[i+1][j] == 1) {
            change(arr,i+1,j);
        }
    }

    public static void  change2(int[][] grid, int i, int j) {
        // 修改为0
        grid[i][j] = 1;
        if (i > 0 && grid[i - 1][j] == 0) {
            // 修改左边的
            change2(grid, i - 1, j);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == 0) {
            // 修改右边的
            change2(grid, i, j + 1);
        }
        if (j > 0 && grid[i][j - 1] == 0) {
            // 修改上边的
            change2(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 0) {
            // 修改下边的
            change2(grid, i + 1, j);
        }
    }
}
