package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC3 {

    /*
    * . Longest Substring Without Repeating Characters
    * Given "dabcabcbb", the answer is "abc", which the length is 3.
    */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i], i);
            } else {
                int index = map.get(array[i]);
                j = Math.max(j, index + 1);
                map.put(array[i], i);
            }
            if(max < i - j + 1) {
                max = i - j + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC3 obj = new LC3();
        int result = obj.lengthOfLongestSubstring("abcabcbb");
        PrintUtils.printString("res:" + result);
    }
}
