package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int prev = map.get(nums[i]);
                if(Math.abs(i - prev) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
