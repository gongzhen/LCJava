package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC340 {

    /**
     * 340. Longest Substring with At Most K Distinct Characters
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     * For example, Given s = “eceba” and k = 2,
     * T is "ece" which its length is 3.
     */

    private static class Solution1 {

        /// https://blog.csdn.net/fantasiasango/article/details/52714485
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if(s == null || s.length() == 0 || k == 0) {
                return 0;
            }
            char[] array = s.toCharArray();
            int j = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0; i < array.length; i++) {
                if(!map.containsKey(array[i])) {
                    if(count < k) {
                        count++;
                        map.put(array[i], i);
                    } else if (count == k) {
                        map.clear();
                        count = 0;
                        int l = i;
                        while(count < k || map.containsKey(array[l])) {
                            if(!map.containsKey(array[l])) {
                                map.put(array[l], l);
                                count++;
                            }
                            l--;
                        }
                        map.put(array[i], i);
                        j = l + 1;
                    }
                } else {
                    map.put(array[i], i);
                }
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }

    private static class Solution2 {

        public int lengthOfLongestSubstringKDistinct1(String s, int k) {
            if(s == null || s.length() == 0 || k == 0) {
                return 0;
            }
            char[] array = s.toCharArray();
            int j = 0;
            int max = 0;
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < array.length; i++) {
                if(!set.contains(array[i])) {
                    if(set.size() < k) {
                        set.add(array[i]);
                    } else if (set.size() == k) {
                        set.clear();
                        int l = i;
                        while(set.size() < k || set.contains(array[l])) {
                            set.add(array[l]);
                            l--;
                        }
                        // set.add(array[i]);
                        j = l + 1;
                    }
                } else {
                    set.add(array[i]);
                }
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }

    private static class Solution3 {
        public int lengthOfLongestSubstringKDistinct2(String s, int k) {
            if(s == null || s.length() == 0 || k == 0) {
                return 0;
            }
            char[] array = s.toCharArray();
            int j = 0;
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < array.length; i++) {
                if(!map.containsKey(array[i])) {
                    map.put(array[i], 1);
                } else {
                    int v = map.get(array[i]);
                    map.put(array[i], ++v);
                }

                while(map.size() > k) {
                    if(map.containsKey(array[j])) {
                        int val = map.get(array[j]);
                        val--;
                        map.put(array[j], val);
                        if(val == 0) {
                            map.remove(array[j]);
                        }
                    }
                    j++;
                }
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }


    public static void main(String[] args) {
        Solution3 obj3 = new Solution3();
        PrintUtils.printString("res:" + obj3.lengthOfLongestSubstringKDistinct2("eceba", 2));
    }
}
