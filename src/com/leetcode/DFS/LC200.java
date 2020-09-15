package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

public class LC200 {
    public int numIslands(char[][] grid) {
        int step = 0;
        int row = grid.length;
        int col = grid[0].length;
        if (row == 0 || col == 0) {
            return step;
        }

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    step++;
                    dfs(grid, row, col, i, j);
                }
            }
        }
        return step;
    }
    private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(char[][] grid, int row, int col, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for(int[] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(grid, row, col, nx, ny);
        }
    }

    public static void main(String[] args) {
        LC200 obj = new LC200();
        int res = obj.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        });
        PrintUtils.printString("res:" + res);
    }
}
