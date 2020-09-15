package com.leetcode.HashTable;

import java.util.HashSet;
import java.util.Set;

public class LC36 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        Set<Character> rowSet = new HashSet<Character>();
        Set<Character> colSet = new HashSet<Character>();
        Set<Character> cubeSet = new HashSet<Character>();
        for (int i = 0; i < board.length; i++) {
            rowSet.clear();colSet.clear();cubeSet.clear();
            for(int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if( c != '.' && rowSet.add(c) == false) {
                    return false;
                }

                c = board[j][i];
                if( c != '.' && colSet.add(c) == false) {
                    return false;
                }

                /// {00, 01, 02, 03, ... 08}
                /// {00 01 02} {03 04 05} {06 07 08}
                /// {10 11 12} {13 14 15}
                /// {20 21 22} {23 24 25}
                /// {30 31 32} {33 34 35}

                int row = 3 * (i / 3) + j / 3; /// 0 0 0 1 1 1 2 2 2
                int col = 3 * (i % 3) + j % 3; /// 0 1 2 0 1 2 0 1 2
                c = board[row][col];
                if(c != '.' && cubeSet.add(c) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
