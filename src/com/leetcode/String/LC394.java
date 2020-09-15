package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC394 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int number = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    number = 10 * number + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(number);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC394 obj = new LC394();
        // String res = obj.decodeString("3[a]ddd2[bc]");
        String res = obj.decodeString("3[a2[c]]"); /// accaccacc
        PrintUtils.printString("res:" + res);
    }
}