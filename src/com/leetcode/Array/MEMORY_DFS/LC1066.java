package com.leetcode.Array.MEMORY_DFS;

import com.leetcode.Helper.PrintUtils;

// https://www.youtube.com/watch?v=nyOE2x5vTUk
public class LC1066 {

    private int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visitedBikes = new boolean[bikes.length];
        dfs(workers, 0, bikes, 0, visitedBikes);
        return min;
    }

    public int assignBikesDP(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        return dfsDP(workers, 0, bikes, 0, dp);
    }

    private int dfsDP(int[][] workers, int wIndex, int[][] bikes, int state, int[] dp) {
        if (wIndex == workers.length) {
            return 0;
        }
        if (dp[state] != 0) {
            return dp[state];
        }
        int _min = Integer.MAX_VALUE;
        for(int i = 0; i < bikes.length; i++) {
            PrintUtils.printString("1 << " + i + ":" + (1 << i));
            PrintUtils.printString("state & 1 << i:" + (state & (1 << i)));
            if ((state & (1 << i)) == 0) { //
                PrintUtils.printString("state | 1 << i:" + (state | 1 << i));
                _min = Math.min(_min, mDistance(workers[wIndex], bikes[i]) + dfsDP(workers, wIndex + 1, bikes, (state | 1 << i), dp));
            }
        }
        dp[state] = _min;
        return _min;
    }

    private void dfs(int[][] workers, int wIndex, int[][] bikes, int sum, boolean[] visited) {
        if (wIndex == workers.length) {
            min = Math.min(min, sum);
            return;
        }
        if (sum > min) {
            return;
        }

        for(int i = 0; i < bikes.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            dfs(workers, wIndex + 1, bikes, sum + mDistance(workers[wIndex], bikes[i]), visited);
            visited[i] = false;
        }
    }

    private int mDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        LC1066 obj = new LC1066();
//        int res = obj.assignBikes(new int[][]{{0,0}, {2,1}}, new int[][]{{1,2}, {3,3}});
        int res = obj.assignBikesDP(new int[][]{{0,0}, {2,1}}, new int[][]{{1,2}, {3,3}});
        PrintUtils.printString("res:" + res);
    }
}
