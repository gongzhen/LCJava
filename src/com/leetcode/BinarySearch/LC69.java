package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

public class LC69 {

    public int mySqrt(int x) {
        int i = 1;
        int j = x;
        int result = 0;
        while (i <= j) {
            int middle = i + (j - i) / 2;
            if (middle * middle > x) {
                j = middle - 1;
            } else {
                i = middle + 1;
                result = middle;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC69 obj = new LC69();
        int res = obj.mySqrt(16);
        PrintUtils.printStringWithoutNewLine("res:" + res);
    }
}
