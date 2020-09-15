package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() <= 10) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i + 10 <= s.length(); i++) {
            String substr = s.substring(i, i + 10);
            map.put(substr, map.getOrDefault(substr, 0) + 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) >= 2) {
                res.add(key);
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
