package com.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // m and n from row and col
        // size < m * n
        // up, down, left, right
        int row = matrix.length;
        List<Integer> res = new ArrayList<Integer>();
        if (row == 0) {
            return res;
        }
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        while(res.size() < row * col) {
            // from let to right
            for (int i = left; i <= right && res.size() < row * col; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // from right top to right bottom
            for (int i = top; i <= bottom && res.size() < row * col; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            for(int i = right; i >= left && res.size() < row * col; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i = bottom; i >= top && res.size() < row * col; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
