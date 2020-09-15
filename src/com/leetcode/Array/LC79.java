package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

public class LC79 {

    public boolean exist(char[][] board, String word) {
        // DFS
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, row, col) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean dfs(char[][] board, String word, int idx, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col) {
            return false;
        }
        if (board[x][y] != word.charAt(idx)) {
            return false;
        }
        if (board[x][y] == word.charAt(idx) && idx == word.length() - 1) {
            return true;
        }

        for (int[] list : dir) {
            int nx = x + list[0];
            int ny = y + list[1];
            if (dfs(board, word, idx + 1, nx, ny, row, col) == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] strs = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        LC79 obj = new LC79();
        String word = "SEE";
        Boolean result = obj.exist(strs, word);
        PrintUtils.printString(":" + result);
        strs = new char[][] {{'a', 'a'}};
        word = "aaa";
        result = obj.exist(strs, word);
        PrintUtils.printString(":" + result);
    }
}
