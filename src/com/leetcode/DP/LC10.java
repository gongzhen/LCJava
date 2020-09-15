package com.leetcode.DP;

import com.leetcode.Helper.*;

/// good explanation.
/// https://blog.csdn.net/hk2291976/article/details/51165010

public class LC10 {

    public boolean isMatch(String s, String p) {
        char[] string  = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] dp = new boolean[string.length + 1][pattern.length + 1];

        dp[0][0] = true;

        for (int i = 2; i < pattern.length + 1; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i < string.length + 1; i++) {
            for (int j = 1; j < pattern.length + 1 ; j++) {
                if (pattern[j - 1] == string[i - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (pattern[j - 1] == '*') {
                        if (dp[i][j - 1] == false && j >= 2) {
//                            String s = "mis + ssss";
//                            String p = "mis*ss*";
//                            String s = "aaaa"
//                            String p = "a*aa*";
                            dp[i][j] = dp[i][j - 2] || ((string[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') && dp[i - 1][j]);
                            // for test2
                            // dp[i][j] = dp[i][j - 2];
                            // for test3 and test4
//                             dp[i][j] = dp[i][j - 2] || ((string[i - 1] == pattern[j - 2] || pattern[j - 2] == '.'));
                        } else if (dp[i][j - 1] == true && j >= 2) {
                            dp[i][j] = dp[i - 1][j] && (string[i - 1] == pattern[j - 2] || pattern[j - 2] == '.');
                        }
                    } else {
                        /// nothing happen here.
                    }
                }
            }
        }
        PrintUtils.printLine();
        PrintUtils.printMatrixBool(dp);
        return dp[string.length][pattern.length];
    }

    public static void main(String[] args) {
        LC10 obj  = new LC10();
//        obj.test1(obj);
//        obj.test2(obj);
        obj.test3(obj);
//        obj.test4(obj);
    }

    private void test1(LC10 obj) {
        String s = "aab";
        String p = "c*a*b";
        boolean result = obj.isMatch(s, p);
        PrintUtils.printString(Boolean.toString(result));
    }

    private void test2(LC10 obj) {
        String s = "aa";
        String p = "a*";
        boolean result = obj.isMatch(s, p);
        PrintUtils.printString(Boolean.toString(result));
    }

    private void test3(LC10 obj) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        boolean result = obj.isMatch(s, p);
        PrintUtils.printString(Boolean.toString(result));
    }

    private void test4(LC10 obj) {
        String s = "aaaa";
        String p = "a*ba*";
        boolean result = obj.isMatch(s, p);
        PrintUtils.printString(Boolean.toString(result));
    }
}
