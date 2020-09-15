package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC974 {

    public int subarraysDivByK(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);
        int sum = 0;
        int carry = 0;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            sum = sum % K;

            if (sum < 0) {
                sum = sum + K;
            }

            // if (map.containsKey(sum)) {
            //     count += map.get(sum);
            //     map.put(sum, count + 1);
            // } else {
            //     map.put(sum, count);
            // }

            // map.put(sum, map.get(sum) + 1);
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        LC974 obj = new LC974();
        int res = obj.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
        PrintUtils.printString("res:" + res);
    }
}
