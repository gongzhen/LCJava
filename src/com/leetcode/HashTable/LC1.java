package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC1 {

    /*
    * 1. Two Sum
    * */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
