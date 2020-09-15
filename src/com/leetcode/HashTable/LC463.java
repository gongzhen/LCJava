package com.leetcode.HashTable;

public class LC463 {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int area = 0;
        int connect = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    area++;
                    if(i > 0 && grid[i - 1][j] == 1) {
                        connect++;
                    }
                    if(i + 1 < m && grid[i + 1][j] == 1) {
                        connect++;
                    }
                    if(j > 0 && grid[i][j - 1] == 1) {
                        connect++;
                    }
                    if(j + 1< n && grid[i][j + 1] == 1) {
                        connect++;
                    }
                }
            }
        }
        return area * 4 - connect;
    }


    public static void main(String[] args) {

    }
}
