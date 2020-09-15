package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

// https://leetcode.wang/leetCode-63-Unique-PathsII.html
// https://leetcode.wang/leetCode-63-Unique-PathsII.html
public class LC63DP {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[row][col];
        // first row
        for(int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                while (i < col) {
                    dp[0][i] = 0;
                    i++;
                }
            } else {
                dp[0][i] = 1;
            }
        }

        // first col
        for(int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < row) {
                    dp[i][0] = 0;
                    i++;
                }
            } else {
                dp[i][0] = 1;
            }
        }

        for(int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        LC63DP obj = new LC63DP();
        int[][] grid = new int[][]{
                {0, 0, 0},//
                {0, 1, 1},// (1, 1),
                {0, 0, 0}};
        // (0, 2) (1, 2) (2, 1)
        int result = obj.uniquePathsWithObstacles(grid);
        PrintUtils.printString("result:" + result);
    }
}
