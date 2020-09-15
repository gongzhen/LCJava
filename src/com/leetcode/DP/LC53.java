package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

public class LC53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int currentMax = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }

    public int maxSubArray_divide_conquer(int[] nums) {
        return divide_conquer(nums, 0, nums.length-1);
    }

    private int divide_conquer(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        if (left == right) {
            return nums[left];
        }

        int midian = left + (right - left) / 2;
        int leftSum = divide_conquer(nums, left, midian);
        int rightSum = divide_conquer(nums, midian + 1, right);
        int result = Math.max(leftSum, rightSum);
        int currentMax = nums[midian];
        int tempMax = currentMax;
        for (int i = midian; i >= 0; i--) {
            tempMax = Math.max(currentMax += nums[i], tempMax);
        }
        currentMax = tempMax;
        for (int i = midian; i <= right; i++) {
            tempMax = Math.max(currentMax += nums[i], tempMax);
        }
        return Math.max(tempMax, result);
    }

    public static void main(String[] args) {
        LC53 obj = new LC53();
        int result = obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        PrintUtils.printString("res:" + result);
    }
}
