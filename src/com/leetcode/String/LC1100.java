package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 *
 * 1100.Find K-Length Substrings With No Repeated Characters
 * Given a string S, return the number of substrings of length K with no repeated characters.
 * Example 1:
 *
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 *
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation:
 * Notice K can be larger than the length of S. In this case is not possible to find any substring.
 *
 *
 * Note:
 *
 * 1 <= S.length <= 10^4
 * All characters of S are lowercase English letters.
 * 1 <= K <= 10^4
 *
 */
public class LC1100 {

    public List<String> numKLenSubstrNoRepeats(String s, int K) {
        if (K > s.length()) {
            return new ArrayList<>();
        }
        int repeated = -1;
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= repeated) {
                repeated = map.get(c);
            }
            if (i - repeated >= K) {
                String str = "";
                if (repeated == -1) {
                    str = s.substring(i - K + 1, i + 1);
                    res.add(str);
                } else {
                    str = s.substring(repeated + 1, i + 1);
                    res.add(str);
                }
                repeated++;
            }
            map.put(c, i);
        }
        return res;
    }

    public List<String> numKLenSubstrNoRepeats1(String s, int K) {
        if (K > s.length()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i + K <= s.length(); i++) {
            String substr = s.substring(i, i + K);
            if (isNoRepeatedString(substr)) {
                res.add(substr);
            }
        }
        return res;
    }

    private boolean isNoRepeatedString(String str) {
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        LC1100 obj = new LC1100();
        List<String> res1 = obj.numKLenSubstrNoRepeats("havefunonleetcode", 5);
        PrintUtils.printListString(res1);
    }
}
