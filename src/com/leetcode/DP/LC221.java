package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

public class LC221 {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];

//        for (int i = 0; i < row; i++) {
//            if (matrix[i][0] == '1') {
//                dp[i][0] = 1;
//            }
//        }
//
//        for (int j = 0; j < col; j++) {
//            if (matrix[0][j] == '1') {
//                dp[0][j] = 1;
//            }
//        }

        PrintUtils.printMatrixInt(dp);

        PrintUtils.printMatrixChar(matrix);
        int maxLen = 0;

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        LC221 obj = new LC221();
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }};
        int res = obj.maximalSquare(matrix);
        PrintUtils.printString("res:" + res);
    }
}
