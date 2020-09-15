package com.leetcode.Stack;

import com.leetcode.Helper.PrintUtils;

import java.util.Stack;

public class LC224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        int sign = 1;
        int result = 0;
        int digit = 0;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(Character.isDigit(c) == true) { // append number from c
                digit = Character.getNumericValue(c);
                num = num * 10 + digit;
            } else if (c == '+') {
                result += sign * num; // result = result + sign * num, 1 + => result : result:0 = result + num:1 * sign
                digit = 0;  // reset digit to 0
                sign = 1;   // sign is +
                num = 0;    // reset num = 0
            } else if (c == '-') {
                result += sign * num; // 1 - => result:0 + sign * num:1
                digit = 0;
                sign = -1;  // current sign is -
                num = 0;
            } else if (c == '(') {
                stack.push(result); // push prev result to stack,
                stack.push(sign);   // push prev sign to stack, sign is 1 or -1
                sign = 1;   // reset to 1
                num = 0;    // reset num to 0
                result = 0; // reset result = 0
            } else if (c == ')') {
                result += sign * num; // 1 + (1 + 2) => result:1 + (+1) * 2 = 3
                result = result * stack.pop(); // result * sign from stack[1, +1] => 1 + 3 => 3 * (+1)
                result += stack.pop(); // result + result from stack.
                num = 0;
            }
        }
        if(num != 0) {
            result += num * sign;
        }
        return result;
    }

    public static void main(String[] args) {
        LC224 obj = new LC224();
        int res = obj.calculate("(1+2)");
        PrintUtils.printString("res:" + res);
        res = obj.calculate("1+(1+2)");
        PrintUtils.printString("res:" + res);
        res = obj.calculate("1+(1+2)+3");
        PrintUtils.printString("res:" + res);
    }
}
