package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

public class LC695 {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        int max = -1;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                // dfs
                if (grid[i][j] == 1) {
                    int[] area = new int[]{0};
                    dfs(grid, i, j, row, col, area);
                    if (max < area[0]) {
                        max = area[0];
                    }
                }
            }
        }
        return max;
    }

    private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int x, int y, int row, int col, int[] area) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
            return;
        }

        area[0]++;
        grid[x][y] = 0;
        for(int[] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(grid, nx, ny, row, col, area);
        }
    }

    public static void main(String[] args) {
        LC695 obj = new LC695();
        int res = obj.maxAreaOfIsland(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        });
        PrintUtils.printString("res:" + res);
    }
}
