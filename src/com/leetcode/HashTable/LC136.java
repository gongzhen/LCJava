package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC136 {

    /*
    * 136. Single Number
    * Given a non-empty array of integers, every element
    * appears twice except for one. Find that single one.
    * [2,2,1]
    * 1
    * */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int v = map.get(nums[i]);
                map.put(nums[i], ++v);
            }
        }
        for(Integer key: map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    private static class Solution1 {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int i = 0; i < nums.length; i++) {
                res ^= nums[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
