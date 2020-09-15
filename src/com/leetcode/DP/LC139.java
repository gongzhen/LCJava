package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        // DP
        Set<String> set = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] == true && set.contains(subStr)) {
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        LC139 obj = new LC139();
        boolean res = obj.wordBreak("leetcode", Arrays.asList("leet", "code"));
        PrintUtils.printBool(res);
    }
}
