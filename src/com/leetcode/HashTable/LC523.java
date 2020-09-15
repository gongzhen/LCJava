package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        // if(nums == null || nums.length == 0 || nums.length == 1) {
        //     return false;
        // }

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0) {
                sum = sum % k;
            }

            if(map.containsKey(sum) == true) {
                int idx = map.get(sum);
                // return true;
                if(i - idx > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC523 obj = new LC523();
        boolean res = obj.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
        PrintUtils.printBool(res);
    }
}
