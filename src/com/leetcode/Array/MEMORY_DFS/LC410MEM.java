package com.leetcode.Array.MEMORY_DFS;

public class LC410MEM {

    public int splitArray(int[] nums, int m) {
        if(nums == null) {
            return -1;
        }
        int[] sums = new int[nums.length];
        int[][] dp = new int[nums.length][m + 1];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < m + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return dfs(nums, nums.length - 1, m, dp, sums);
    }

    private int dfs(int[] nums, int k, int m, int[][] dp, int[] sums) {
        if (m == 1) {
            return nums[k];
        }
        if (m > k + 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[k][m] != Integer.MAX_VALUE) {
            return dp[k][m];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            int max = Math.max(dfs(nums, k - 1, m, dp, sums), sums[k] - sums[i]);
            ans = Math.min(ans, max);
        }
        dp[k][m] = ans;
        return ans;
    }
    public static void main(String[] args) {
        LC410MEM obj = new LC410MEM();
        obj.splitArray(new int[]{7,2,5,10,8}, 2); // max = 10 and sum = 22, and m = 2, and subsum is minimal.
    }
}
