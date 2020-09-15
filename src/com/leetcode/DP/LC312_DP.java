package com.leetcode.DP;

public class LC312_DP {

    public int maxCoins(int[] nums) {
        int[] coins = new int[nums.length + 2];
        int x = 1;
        for (int n : nums) {
            if (n > 0) {
                coins[x++] = n;
            }
        }
        coins[0] = coins[x++] = 1;
        int [][] dp = new int[coins.length][coins.length];
        for (int i = 2; i < dp.length; i++) {
            for (int left = 0; left < dp.length - i; left++) {
                int right = left + i;
                for (int j = left + 1; j < right; j++) {
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {

    }
}
