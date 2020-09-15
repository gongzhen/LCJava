package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

public class LC34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                // >= mid
                left = mid + 1;
            }
        }
        int[] res = new int[]{-1, -1};
        if (target == nums[left]) {
            res[0] = left;
        }

        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else { // target <= mid
                left = mid;
            }
        }

        if (target == nums[right]) {
            res[1] = right;
        }

        return res;
    }

    public static void main(String[] args) {
        LC34 obj = new LC34();
        int[] res = obj.searchRange(new int[]{5,7,7,8,8,10}, 8);
        PrintUtils.printArray(res);
    }
}
