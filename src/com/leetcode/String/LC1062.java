package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 *
 * Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
 * Input: "abcd"
 * Output: 0
 * Input: "abbaba"
 * Output: 2
 * Input: "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 * Input: "aaaaa"
 * Output: 4
 * The string S consists of only lowercase English letters from 'a' - 'z'.
 * 1 <= S.length <= 1500
 *
 */

public class LC1062 {

    // https://github.com/openset/leetcode
    // https://github.com/ScientificKnights/Leetcode-Templates-and-Examples/blob/master/code/1062.%20Longest%20Repeating%20Substring.h
    public int findLongestRepeatingSubSeq1(String str) {
        if(str.length() == 0) {
            return 0;
        }
        //     a b b a b a
        //   a
        //   b
        //   b
        //   a
        //   b
        //   a
        str = " " + str;
        int len = str.length();
        int res = 0;
        int[][] dp = new int[len][len];
        for (int i = 1; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public List<String> findLongestRepeatingSubSeq(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length() + 1; j++) {
                String substr = str.substring(i, j);
                if (map.containsKey(substr)) {
                    map.put(substr, map.get(substr) + 1);
                } else {
                    map.put(substr, 1);
                }
            }
        }

        for(String key : map.keySet()) {
            int count = map.get(key);
            if (count > 1) {
                res.add(key);
            }
        }
        if (res.size() == 0) {
            return res;
        }
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { // desecending order.
                if (o1.length() == o2.length()) {
                    return 0;
                } else if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        List<String> list = new ArrayList<>();
        int max = res.get(0).length();
        for(String word : res) {
            if (word.length() == max) {
                list.add(word);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC1062 obj = new LC1062();
        List<String> res1 = obj.findLongestRepeatingSubSeq("abbaba");
        PrintUtils.printListString(res1);
        List<String> res2 = obj.findLongestRepeatingSubSeq("aabcaabdaab");
        PrintUtils.printListString(res2);
        List<String> res3 = obj.findLongestRepeatingSubSeq("abcd");
        PrintUtils.printListString(res3);
        List<String> res7 = obj.findLongestRepeatingSubSeq("aaaaa");
        PrintUtils.printListString(res7);

        int res4 = obj.findLongestRepeatingSubSeq1("abbaba");
        PrintUtils.printString("res4:" + res4);
        int res5 = obj.findLongestRepeatingSubSeq1("aabcaabdaab");
        PrintUtils.printString("res5:" + res5);
        int res6 = obj.findLongestRepeatingSubSeq1("abcd");
        PrintUtils.printString("res6:" + res6);
        int res8 = obj.findLongestRepeatingSubSeq1("aaaaa");
        PrintUtils.printString("res8:" + res8);
    }
}
