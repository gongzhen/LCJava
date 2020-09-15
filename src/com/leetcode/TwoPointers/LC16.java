package com.leetcode.TwoPointers;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;

public class LC16 {

    public int threeSumClosest(int[] nums, int target) {

        int sum = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int subsum = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int total = nums[j] + nums[k];
                if (total > subsum) {
                    k--;
                } else {
                    j++;
                }
                if(diff >= Math.abs(subsum - total)) {
                    diff = Math.abs(subsum - total);
                    sum = nums[i] + total;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LC16 obj = new LC16();
//        int[] array = new int[]{-1, 2, 1, -4};
        int[] array = new int[]{1, 1, -1, -1, 3};
        int result = obj.threeSumClosest(array, -1);
        PrintUtils.printString(":" + result);
    }

}
