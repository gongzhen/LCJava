package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
You are in charge of preparing a recently purchased lot for one of Amazon's new buildings.
The lot is covered with trenches and has a single obstacle that needs to be taken down
before the foundation can be prepared for the building. The demolition robot must remove the
obstacle before progress can be made on the building. Write an algorithm to determine the
minimum distance required for the demolition robot to remove the obstacle.



Assumptions:

• The lot is flat, except for trenches, and can be represented as a two-dimensional grid.

• The demolition robot must start from the top-left corner of the lot, which is always flat,
and can move one block up, down, left, or right at a time.

• The demolition robot cannot enter trenches and cannot leave the lot.

• The flat areas are represented as 1, areas with trenches are represented by 0 and the
obstacle is represented by 9.



Input

The input to the function/method consists of three arguments:

numRows, an integer representing the number of rows;

numColumns, an integer representing the number of columns;

lot, representing the two-dimensional grid of integers.



Output

Return an integer representing the minimum distance traversed to remove the obstacle else return -1.



Constraints

1 <= numRows, numColumns <=1000



Example

Input:

numRows= 3

numColumns = 3

lot= [ [1, 0, 0],

         [1, 0, 0],

         [1, 9, 1]]

Output:

3



题意：

在一个matrix中， 1 代表有路，0代表没路，9代表目的地。从左上角出发，求达到目的地9的最短距离。如果到达不了，返回-1。

注意几个边界条件：这题隐藏了一个条件就是机器人从左上角的(0,0)坐标出发，意味着(0,0) 坐标对应的值一定为1，否则直接无解返回-1。但有一个坑，如果出发点为9，则需return 0



思路：

BFS
*/
public class REMOVEOBSTABLE {

    private static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int removeObstacle(int numRows, int numColumns, int[][] lot) {

        int row = lot.length;
        int col = lot[0].length;

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }
        if (lot[0][0] == 0) {
            return -1;
        }
        visited[0][0] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        int step = 0;
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                for (int[] list : dir) {
                    int nx = p.x + list[0];
                    int ny = p.y + list[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && visited[nx][ny] == false && lot[nx][ny] != 0) {
                        if (lot[nx][ny] == 9) {
                            return step;
                        }

                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }

    public static void test1() {
        REMOVEOBSTABLE obj = new REMOVEOBSTABLE();
        int result = obj.removeObstacle(5, 4, new int[][]{{1, 1, 1, 1}, {0, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 9, 1}, {0, 0, 1, 1}});
        PrintUtils.printString(":" + result);
    }

    public static void test2() {
        REMOVEOBSTABLE obj = new REMOVEOBSTABLE();
        int result = obj.removeObstacle(3, 3, new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 9, 1}});
        PrintUtils.printString(":" + result);
    }
}
