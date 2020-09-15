package com.leetcode.Array;

import java.util.Arrays;

public class LC561 {

    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;
        for(int i = nums.length - 1; i - 1 >= 0; i = i - 2) {
            sum += Math.min(nums[i], nums[i - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        LC561 obj = new LC561();
        obj.arrayPairSum(new int[]{1, 4, 3, 2});
    }
}
