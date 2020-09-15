package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

public class LC37 {

    public void solveSudoku(char[][] board) {
        if(board.length ==0) {
            return;
        }
        backtrack(board, board.length, board[0].length);
    }

    private boolean backtrack(char[][] board, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(valid(board, i, j, c) == true) {
                            board[i][j] = c;
                            if(backtrack(board, m, n) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                } else {
                    /// todo
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, char c)  {
        for(int x = 0; x < 9; x++) {
            if(x != i && board[x][j] == c) {
                return false;
            }

            if(x != j && board[i][x] == c) {
                return false;
            }
            // 00 01 02 03 04 05 06 07 08
            // 10 11 12 13 14 15 16 17 18
            // 20 21 22 23 24 25 26 27 28
            // 30 31 32 33 34 35 36 37 38
            // 40 41 42 43 44 45 46 47 48
            // 50 51 52 53 54 55 56 57 58

            // i=2 j=3
            // x/3 from 0 to 2 is 0, from 3 to 5 is 1, from 6 to 8 is 2
            // x%3 from 0 to 2 is 0-2, from 3 to 5 is 0-2 from 6 to 8 is 0-2
            int row = 3 * (i / 3) + x / 3;
            int col = 3 * (j / 3) + x % 3;
            if(board[row][col] == c && (row != i || col != j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                 {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        LC37 obj = new LC37();
        obj.solveSudoku(board);
        PrintUtils.printMatrixChar(board);
    }

}
