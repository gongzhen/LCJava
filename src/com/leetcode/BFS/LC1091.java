package com.leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091 {

    private static class Index {
        private int x;
        private int y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Index> queue = new LinkedList<Index>();
        queue.offer(new Index(0, 0));
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row-1][col-1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        int step = 0;
        while(queue.isEmpty() == false) {
            step++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Index index = queue.poll();
                if (index.x == row-1 && index.y == col-1) {
                    return step;
                }
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <=1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int nx = index.x + i;
                        int ny = index.y + j;
                        if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 0 && visited[nx][ny] == false) {
                            queue.offer(new Index(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
