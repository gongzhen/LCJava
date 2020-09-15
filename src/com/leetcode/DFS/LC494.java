package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

public class LC494 {

    private static int res = 0;
    public int findTargetSumWays1(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return res;
    }

    private void dfs1(int[] nums, int S, int current, int idx) {
        if (idx == nums.length) {
            if(current == S) {
                res++;
            }
            return;
        }

        dfs(nums, S, current + nums[idx] * 1, idx + 1);
        dfs(nums, S, current - nums[idx] * 1, idx + 1);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0, 0);
    }

    private int dfs(int[] nums, int S, int current, int idx) {
        if (idx == nums.length) {
            if(current == S) {
                return 1;
            } else {
                return 0;
            }
        }

        int add = dfs(nums, S, current + nums[idx] * 1, idx + 1);
        int minus = dfs(nums, S, current - nums[idx] * 1, idx + 1);
        return add + minus;
    }

    public static void main(String[] args) {
        LC494 obj = new LC494();
        int res = obj.findTargetSumWays1(new int[]{1}, 1);
        PrintUtils.printString("res: " + res);
    }
}
