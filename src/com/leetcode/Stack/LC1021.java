package com.leetcode.Stack;

import com.leetcode.Helper.PrintUtils;

public class LC1021 {
    public String removeOuterParentheses(String S) {
        char[] array = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int valid = 0;
        boolean first = false;
        int start = 0;
        int end = 0;
        for(int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(') {
                valid++;
            } else if (c==')') {
                valid--;
            }

            if (valid == 0) {
                end = i;
                String subStr = S.substring(start + 1, end);
                sb.append(subStr);
                start = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC1021 obj = new LC1021();
        String res = obj.removeOuterParentheses("(()())(())");
        PrintUtils.printString(res);
    }
}
