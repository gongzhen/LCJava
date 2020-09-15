package com.leetcode.BFS;

import com.leetcode.Helper.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

public class LC934 {

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] A, Queue<Coordinate> queue, int row, int col, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || A[x][y] != 1) { // not 1 then it is 0 or 2
            return;
        }
        A[x][y] = 2;
        queue.offer(new Coordinate(x, y));
        for(int[] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(A, queue, row, col, nx, ny);
        }
    }

    public int shortestBridge(int[][] A) {
        int row = A.length;
        if (row == 0) {
            return 0;
        }
        int col = A[0].length;
        Queue<Coordinate> queue = new LinkedList<>();

        boolean found = false;
        for(int i = 0; i < row; i++) {
            for(int j = 0; found == false && j < col; j++) {
                if (A[i][j] == 1) {
                    found = true;
                    dfs(A, queue, row, col, i, j);
                }
            }
        }

        int step = 0;
        while(queue.isEmpty() == false) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                for(int[] dir : direction) {
                    int nx = coordinate.x + dir[0];
                    int ny = coordinate.y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || A[nx][ny] == 2) { // continue
                        continue;
                    }
                    if (A[nx][ny] == 1) { // stop
                        return step;
                    }
                    A[nx][ny] = 2; // 0 to 2
                    queue.offer(new Coordinate(nx, ny));
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {{0, 1},{1, 0}};
        LC934 obj = new LC934();
        int res = obj.shortestBridge(A);
        PrintUtils.printString("res:" + res);
    }
}
