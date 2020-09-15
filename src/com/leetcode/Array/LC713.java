package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC713 {

    // TIME LIMITED EXCEED.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 2, 5, 6, 10  k = 100
        List<List<Integer>> res1 = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                continue;
            }
            int j = i;
            int product = 1;
            List<Integer> list = new ArrayList<>();
            while (j < nums.length && product < k) {
                product = product * nums[j];
                if (product < k) {
                    list.add(nums[j]);
                    res++;
                }
                j++;
            }
            res1.add(list);
        }
        PrintUtils.printListOfListInteger(res1);
        return res;
    }

    public int numSubarrayProductLessThanK_MaxProductWindow(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LC713 obj = new LC713();
        int result1 = obj.numSubarrayProductLessThanK(new int[]{1,1,1,8,1}, 5);
        PrintUtils.printString("res1:" + result1);
        int result2 = obj.numSubarrayProductLessThanK_MaxProductWindow(new int[]{1,1,1,8,1}, 5);
        PrintUtils.printString("res2:" + result2);
    }
}
