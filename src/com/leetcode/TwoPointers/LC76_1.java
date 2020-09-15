package com.leetcode.TwoPointers;

import com.leetcode.Helper.PrintUtils;

public class LC76_1 {

    public String minWindow(String s, String t) {
        return "";
    }

    public static void main(String[] args) {
        LC76_1 obj = new LC76_1();
        String res = obj.minWindow("ADOBECODEBANC", "ABC");
        PrintUtils.printString("res:" + res);
        res = obj.minWindow("ab", "a");
        PrintUtils.printString("res:" + res);
        res = obj.minWindow("acbbaca", "aba");
        PrintUtils.printString("res:" + res);
    }
}
