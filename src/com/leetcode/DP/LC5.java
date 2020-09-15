package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

public class LC5 {

    public String longestPalindrome(String s) {
        // babad
        if(s.length() == 0) {
            return "";
        }

        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j+1][i-1] == true) ;
                if(dp[j][i] == true && i - j + 1 > res.length()) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;

//        if(s.length() == 0) {
//            return "";
//        }
//
//        String res = "";
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int max = 0;
//        for(int i = 0; i < s.length(); i++) {
//            for(int j = 0; j <= i; j++) {
//                dp[i][j] = s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[i-1][j+1] == true) ;
//                if(dp[i][j] == true && i - j + 1 > res.length()) {
//                    res = s.substring(j, i + 1);
//                }
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        LC5 obj = new LC5();
        String res = obj.longestPalindrome("babab");
        PrintUtils.printString("res:" + res);
    }
}
