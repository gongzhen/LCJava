package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                int v = map.get(n);
                map.put(n, ++v);
            }
        }

        for(int key: map.keySet()) {
            if(map.get(key) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
