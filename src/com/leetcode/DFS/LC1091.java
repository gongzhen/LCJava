package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;


/**

1: start from (0, 0) which dist(0, 0) is Integer_max and let d0 = dist(0, 0)
2: with direction array for eight directions, get new_x and new_y with direction. check neighbor if the value is 1 or 0.
3: If it is 1, then stop.
if it is 0, it will start from here.
Compare dist(new_x, new_y) and d0
if dist(new_x, new_y) + 1 < d0: // neighbor has smaller value, then (x, y) = dist(new_x, new_y) + 1
					dist(x, y) = dist(new_x, new_y) + 1
					dfs(dist, grid, new_x, new_y)
else if dist(new_x, new_y) > d0 + 1: // neighbor has large value, then (new_x, new_y) will have d0 + 1
					dfs(new_x, new_y) = d0 + 1
					dfs(dist, grid, new_x, new_y)

*/

public class LC1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][] dist = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 1;
        if (grid[0][0] == 1 || grid[row-1][col-1] == 1) {
            return -1;
        }
        dfs(grid, row, col, 0, 0, dist);

        return dist[row-1][col-1] != Integer.MAX_VALUE ? (int)dist[row-1][col-1] : -1;
    }

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public void dfs(int[][] grid, int row, int col, int x, int y, long[][] dist) {
        long d0 = dist[x][y]; // original
        for (int [] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 0) {
                // neighbors
                long d1 = dist[nx][ny];
                if (d0 > d1 + 1) {
                    // neighbor has smaller value
                    dist[x][y] = d1 + 1;
                    dfs(grid, row, col, x, y, dist);
                } else if (d1 > d0 + 1) { // original x, y has smaller value
                    dist[nx][ny] = d0 + 1;
                    dfs(grid, row, col, nx, ny, dist);
                }
            }
        }
    }

    public static void main(String[] args) {
        LC1091 obj = new LC1091();
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
        int result = obj.shortestPathBinaryMatrix(grid);
        PrintUtils.printString("result:" + result);
    }
}
