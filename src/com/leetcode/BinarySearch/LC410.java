package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

public class LC410 {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max); // find the max of nums
            sum += num;               // find the sum of nums
        }
        if (m == 1) {
            return (int)sum;
        }
        //binary search
        long l = max;
        long r = sum; // max is left, sum is right
        while (l < r) {
            long mid = l + (r - l) / 2; // mid is between max and sum
            int pieces = split(mid, nums);
            if (pieces == m) {
                r = mid; // move right to mid, we are looking for the minimal sum.
            } else if (pieces < m) { // passing mid index, nums and m. mid is target.
                r = mid; // it is possible the result
            } else {
                l = mid + 1;
            }

////          same but reverse
//            if (pieces > m) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
        }
        return (int)l;
    }

    public int split(long mid, int[] nums) { // target is mid, m is m groups of nums.
        int count = 1;
        int sum = 0;
        for(int n : nums) {
            if (sum + n > mid) {
                sum = n;
                count++;
            } else {
                sum += n;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC410 obj = new LC410();
        obj.splitArray(new int[]{7,2,5,10,8}, 2); // max = 10 and sum = 22, and m = 2, and subsum is minimal.
    }
}
