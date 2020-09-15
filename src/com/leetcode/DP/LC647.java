package com.leetcode.DP;

import com.leetcode.Helper.PrintUtils;

public class LC647 {

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i-1][j+1] == true);
                if (dp[i][j]) res++;
            }
        }
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//                if(dp[i][j]) {
//                    ++res;
//                }
//            }
//        }
        return res;
    }

//    int res = 0;
//        for(int i = 0; i < s.length(); i++) {
//        for(int j = i + 1; j <= s.length(); j++) {
//            String substr = s.substring(i, j);
//            if(isPalindrome(substr) == true) {
//                res++;
//            }
//        }
//    }
//        return res;

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] array = s.toCharArray();
        boolean isPalindrome = true;
        while(i < j) {
            if (array[i] == array[j]) {
                i++;
                j--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        LC647 obj = new LC647();
        int res = obj.countSubstrings("abc");
        PrintUtils.printString("res:" + res);
    }
}
