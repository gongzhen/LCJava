package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

public class LC85 {

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        PrintUtils.printMatrixChar(matrix);
        int row = matrix.length;
        int col = matrix[0].length;

        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        int res = 0;
        for(int i = 0; i < col; i++) {
            right[i] = col;
        }

        for(int i = 0; i < row; i++) {
            int currentLeft = 0, currentRight = col;
            for(int j = 0; j < col; j++) {
                /// left holds the first index of 1's after 0.
                if( matrix[i][j] == '1') {
                    left[j]  = Math.max(currentLeft, left[j]);
                } else {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
            }

            for(int j = col - 1; j >= 0; j--) {
                /// right
                if( matrix[i][j] == '1') {
                    right[j]  = Math.min(currentRight, right[j]);
                } else {
                    right[j] = col;
                    currentRight = j;
                }
            }

            for(int j = 0; j < col; j++) {
                if( matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for(int j = 0; j < col; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[][] strs = new String[][] {
                {"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}
        };

        char[][] matrix = new char[strs.length][strs[0].length];
        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < strs[0].length; j++) {
                matrix[i][j] = strs[i][j].charAt(0);
            }
        }

        LC85 obj = new LC85();
        obj.maximalRectangle(matrix);
    }
}
