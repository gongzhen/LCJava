package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

public class LC76 {

    public String minWindow(String s, String t) {
        int count = t.length();
        int[] map = new int[64];
        for (char c : t.toCharArray()) {
            map[c - 'A']++;
        }
        int i = 0;
        int j = 0;
        int min = s.length() + 1;
        int header = 0;
        while (i < s.length()) {
            if (map[s.charAt(i++) - 'A']-- > 0) {
                count--;
            }

            while (count == 0) {
                if (min > i - j) {
                    min = i - j;
                    header = j;
                }

                if (map[s.charAt(j++) - 'A']++ == 0) {
                    count++;
                }
            }
        }
            /// min == s.length() + 1
            /// s:a t:aa
        return min == s.length() + 1 ? "" : s.substring(header, header + min);
    }

    public static void main(String[] args) {
        LC76 obj = new LC76();
        String res = obj.minWindow("ADOBECODEBANC", "ABC");
        PrintUtils.printString("res:" + res);
    }

}
