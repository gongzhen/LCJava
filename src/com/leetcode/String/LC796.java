package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

public class LC796 {

    public boolean rotateString(String A, String B) {
        for (int i = 1; i < A.length() - 1; i++) {
            String first = A.substring(0, i);
            String second = A.substring(i);
            String target = second + first;
            if (target.equals(B)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC796 obj = new LC796();
        boolean res= obj.rotateString("abcde", "cdeab");
        PrintUtils.printString("res:" + res);
    }
}
