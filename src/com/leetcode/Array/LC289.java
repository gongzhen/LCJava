package com.leetcode.Array;

public class LC289 {

    // https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
    private static final int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private static final int DEADTOLIVE = 2;
    private static final int ALIVETODEAD = 3;

    public void gameOfLife1(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alive = 0;
                for (int[] direction : directions) {
                    alive += isAlive(board, m, n, i + direction[0], j + direction[1]) ? 1 : 0;
                }

                if (board[i][j] == DEAD) {
                    if (alive == 3) {
                        board[i][j] = DEADTOLIVE;
                    }
                } else {
                    if (alive != 2 && alive != 3) {
                        board[i][j] = ALIVETODEAD;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == DEADTOLIVE) {
                    board[i][j] = ALIVE;
                } else if (board[i][j] == ALIVETODEAD){
                    board[i][j] = DEAD;
                }
            }
        }
    }

    private boolean isAlive(int[][] board, int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n && (board[i][j] == ALIVE || board[i][j] == ALIVETODEAD);
    }

    public static void main(String[] args) {

    }
}
