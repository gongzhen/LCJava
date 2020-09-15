package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

public class LC153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left < right) {
            if(nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LC153 obj = new LC153();
        int res = obj.findMin(new int[]{4,5,6,7,0,1,2});
        PrintUtils.printString("res: " + res);
    }
}
