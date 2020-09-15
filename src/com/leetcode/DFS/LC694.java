package com.leetcode.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC694 {
    /**
     * 694.Number of Distinct Islands
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land
     * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     *
     * Count the number of distinct islands. An island is considered to be the same as another
     * if and only if one island can be translated (and not rotated or reflected) to equal the other.
     *
     * Example 1:
     * 11000
     * 11000
     * 00011
     * 00011
     * Given the above grid map, return 1.
     *
     * Example 2:
     * 11011
     * 10000
     * 00001
     * 11011
     * Given the above grid map, return 3.
     *
     * Notice that:
     * 11
     * 1
     * and
     *  1
     * 11
     * are considered different island shapes, because we do not consider reflection / rotation.
     * Note: The length of each dimension in the given grid does not exceed 50.
     *
     */

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return  0;
        }
        int col = grid[0].length;
        Set<List<Pair>> res = new HashSet<>();
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    List<Pair> list = new ArrayList<>();
                    dfs(grid, list, i, j, i, j, row, col);
                    res.add(list);
                }
            }
        }
        return res.size();
    }

    private int[][] direction = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    private void dfs(int[][] grid, List<Pair> list, int x, int y, int basex, int basey, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == -1 || grid[x][y] == 0) {
            return;
        }

        grid[x][y] = -1;
        list.add(new Pair(x - basex, y - basey));
        for(int [] dir : direction) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            dfs(grid, list, nx, ny, basex, basey, row, col);
        }
    }

    public static void main(String[] args) {

    }
}
