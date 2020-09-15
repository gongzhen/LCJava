package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int key: map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            res.addAll(bucket[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
