package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

public class LC31 {

    public void nextPermutation(int[] nums) {

        int m = -1, n = -1;
        int len = nums.length;
        for(int i = len-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                m = i; /// find the first index which nums[index] < nums[index+1]
                break;
            }
        }

        if (m >= 0) {
            for(int i = len-1; i>m; i--) {
                if (nums[m] < nums[i]) {
                    n = i;
                    break;
                }
            }
            swap(nums, m, n);
            reverse(nums, m+1, len-1);
        } else {
            reverse(nums, 0, len-1);
        }
        PrintUtils.printArray(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int s, int e)
    {
        int i = s;
        int j = e;
        while(i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        LC31 obj = new LC31();
        obj.nextPermutation(new int[]{1, 2, 3});
        obj.nextPermutation(new int[]{3, 2, 1});
        obj.nextPermutation(new int[]{1, 1, 5});
    }
}
