package com.leetcode.DIVIDEANDCONQUER;

import com.leetcode.Helper.PrintUtils;

public class LC215 {

    // https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time
    public int findKthLargest2(int[] nums, int k) {
        // solution from leetcode discussion. it is a iterative solution.
        return 0;
    }

    public int findKthLargest(int[] nums, int k) {
        // selection
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        k = nums.length - k;
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            // index = partition(nums, i, j);
            index = partition_2(nums, i, j);
            if (index == k) {
                break;
            } else if (index < k) {
                i = index + 1;
            } else {
                j = index - 1;
            }
        }

        if (i > j) {
            return nums[j];
        }
        return nums[index];
    }

    private int partition(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int pivot = nums[start];

        while (i < j) {
            while (i < end && nums[i] <= pivot) {
                i++;
            }

            while (j > start && nums[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, start, j);
        return j;
    }

    private int partition_2(int[] nums, int left, int right) {
        int pivotIndex = left + (right - left) / 2;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int leftBound = left;
        int rightBound = right;
        while (leftBound <= rightBound) {
            if (nums[leftBound] >= pivot) {
                leftBound++;
            } else if (nums[rightBound] < pivot) {
                rightBound--;
            } else {
                swap(nums, leftBound++, rightBound--);
//                leftBound++;
//                rightBound--;
            }
        }
        swap(nums, leftBound, right);
        return leftBound;
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC215 obj = new LC215();
        int res = obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        PrintUtils.printString("res:" + res);
    }
}
