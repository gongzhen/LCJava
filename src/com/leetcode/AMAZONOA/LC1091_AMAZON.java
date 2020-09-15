package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 *

 Treasure Island
 You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
 There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 Assume the map area is a two dimensional grid, represented by a matrix of characters.
 You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
 The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
 Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
 Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
 Output the minimum number of steps to get to the treasure.
 from aonecode.com

 e.g.
 Input
 [
 [‘O’, ‘O’, ‘O’, ‘O’],
 [‘D’, ‘O’, ‘D’, ‘O’],
 [‘O’, ‘O’, ‘O’, ‘O’],
 [‘X’, ‘D’, ‘D’, ‘O’],
 ]

 Output from aonecode.com
 Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.

*/

public class LC1091_AMAZON {

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPathBinaryMatrix(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        queue.offer(new Pair(0, 0));
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for (int[] array : direction) {
                    int nx = pair.x + array[0];
                    int ny = pair.y + array[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && visited[nx][ny] == false) {
                        if (grid[nx][ny] == 'X') {
                            return step;
                        } else if (grid[nx][ny] == 'O') {
                            visited[nx][ny] = true;
                            queue.offer(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1091_AMAZON obj = new LC1091_AMAZON();
        char[][] grid = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
                { 'X', 'D', 'D', 'O' } };
        int result = obj.shortestPathBinaryMatrix(grid);
        PrintUtils.printString(":" + result);
    }
}
