package com.leetcode.Stack;

import com.leetcode.Array.LC85;
import com.leetcode.Helper.PrintUtils;

import java.util.Stack;

public class LC856 {

    public int scoreOfParentheses(String S) {
//        Stack<Integer> stack = new Stack<>();
//        int cur = 0;
//        for (char c : S.toCharArray()) {
//            if (c == '(') {
//                stack.push(cur);
//                cur = 0;
//            } else {
//                cur = stack.pop() + Math.max(cur * 2, 1);
//            }
//        }
//        return cur;

        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                l++;
            } else {
                l--;
            }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                res += 1 << l;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC856 obj = new LC856();
        int res = obj.scoreOfParentheses("(()(()))");
        PrintUtils.printString("res:" + res);
    }
}
