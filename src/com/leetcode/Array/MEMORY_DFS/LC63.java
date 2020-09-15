package com.leetcode.Array.MEMORY_DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }

        Map<String, Integer> visited = new HashMap<>();
        return DFS(obstacleGrid, row, col, 0, 0, visited);
    }

    public int DFS(int[][] grid, int row, int col, int x, int y, Map<String, Integer> map) {
        String key = x + ", " + y;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (x == row-1 && y == col-1) {
            if (grid[x][y] == 1) {
                return 0;
            } else {
                return 1;
            }
        } else if (x >= row || y >= col) {
            return 0;
        }

        if (grid[x][y] == 1) {
            if (map.containsKey(key)) {
                map.put(key, 0);
            }
            return 0;
        }

        int right = DFS(grid, row, col, x, y + 1, map);
        int down = DFS(grid, row, col, x + 1, y, map);
        map.put(key, right + down);
        return right + down;
    }


    public static void main(String[] args) {
        LC63 obj = new LC63();
        int[][] grid = new int[][]{
                {0, 0, 0},//
                {0, 1, 1},// (1, 1),
                {0, 0, 0}};
        // (0, 2) (1, 2) (2, 1)
        int result = obj.uniquePathsWithObstacles(grid);
        PrintUtils.printString("result:" + result);
    }

}
