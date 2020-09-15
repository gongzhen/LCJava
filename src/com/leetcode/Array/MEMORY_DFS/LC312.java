package com.leetcode.Array.MEMORY_DFS;

import com.leetcode.Helper.PrintUtils;

public class LC312 {

    public int maxCoins(int[] nums) {
        int[] coins = new int[nums.length + 2];
        int x = 1;
        for (int n : nums) {
            if (n > 0) {
                coins[x++] = n;
            }
        }
        coins[0] = coins[x++] = 1;
        int[][] memo = new int[coins.length][coins.length];

        return dfs(memo, coins, 0, coins.length - 1);
    }

    private int dfs(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + dfs(memo, nums, left, i) + dfs(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        LC312 obj = new LC312();
        int res = obj.maxCoins(new int[]{3, 1, 5, 8});
        PrintUtils.printString("res:" + res);
    }
}
