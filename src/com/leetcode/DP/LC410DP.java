package com.leetcode.DP;

public class LC410DP {

    public int splitArray(int[] nums, int m) {
        if(nums == null) {
            return -1;
        }

        int[][] dp = new int[m][nums.length];
        /**
         *
         * m = 2, nums.length = 5
         * [7, 2+7, 9+5, 14+10, 24+8]
         * [0,  0,   0,    0,    0]
         *
         * */
        dp[0][0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            dp[0][i] = nums[i]+dp[0][i-1];
        }
        /**
         *
         * m = 2, nums.length = 5
         * [7, 2+7, 9+5, 14+10, 24+8]
         * [0,  0,   0,    0,    0]
         *
         * */
        for(int i=1; i<m; i++){
            for(int j=i; j<nums.length; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=0; k<j; k++){
                    min = Math.min(min, Math.max(dp[i-1][k], dp[0][j]-dp[0][k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[m-1][nums.length-1];
    }

    public static void main(String[] args) {
        LC410DP obj = new LC410DP();
        obj.splitArray(new int[]{7,2,5,10,8}, 2); // max = 10 and sum = 22, and m = 2, and subsum is minimal.
    }
}
