package com.leetcode.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        /// 1 1 2 2
        /// 1 2 2
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] res = new int[set.size()];
        i = 0;
        for(int n : set) {
            res[i++] = n;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
