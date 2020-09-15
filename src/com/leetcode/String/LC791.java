package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

public class LC791 {

    public String customSortString(String S, String T) {
        int[] map = new int[26];
        for(char c : T.toCharArray()) {
            ++map[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while(map[c - 'a'] > 0) {
                sb.append(c);
                map[c - 'a']--;
            }
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (map[c - 'a'] > 0) {
                sb.append(c);
                map[c - 'a']--;
            }    // group chars in T but not in S.
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC791 obj = new LC791();
        String res = obj.customSortString("cba", "abcd");
        PrintUtils.printString("res:" + res);
    }
}
