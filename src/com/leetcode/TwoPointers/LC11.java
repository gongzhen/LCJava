package com.leetcode.TwoPointers;

import com.leetcode.Helper.PrintUtils;

public class LC11 {

    public int maxArea(int[] height) {
        if(height.length == 0) {
            return 0;
        }

        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            max = Math.max(max, w * h);
            if(height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC11 obj = new LC11();
        PrintUtils.printString("res:" + obj.maxArea(new int[]{1, 1}));
    }
}
