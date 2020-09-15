package com.leetcode.Stack;

import com.leetcode.Helper.PrintUtils;

import java.util.Stack;

public class LC227 {

    public int calculate(String s) {
        Stack<Integer> number = new Stack<>();
        int lastNumber = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) == true) {
                lastNumber = lastNumber * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    number.push(lastNumber);
                } else if (lastSign == '-') {
                    number.push(-lastNumber);
                } else if (lastSign == '*') {
                    number.push(number.pop() * lastNumber);
                } else if (lastSign == '/') {
                    number.push(number.pop() / lastNumber);
                }
                lastNumber = 0;
                lastSign = c;
            }
        }

        int sum = 0;
        while(!number.isEmpty()) {
            sum += number.pop();
        }
        return sum;
    }

    // https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
    public int calculate2(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum+=tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+=tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num=0;
            }
        }
        sum+=tempSum;
        return sum;
    }

    public int calculate3(String s) {
        int result = 0;
        int num = 0;
        int prev = 0;
        char sign = '+';
        // + 1 + 2 * 3 - 4
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            char c = array[i];
            if (Character.isDigit(c) == true) {
                num = num * 10 + c - '0';
            }
            if (i == array.length - 1 || (Character.isDigit(c) == false && c != ' ')) {
                if (sign == '+') {
                    result += prev;
                    prev = num;
                } else if (sign == '-') {
                    result += prev;
                    prev = -num;
                } else if (sign == '*') {
                    prev = prev * num;
                } else if (sign == '/') {
                    prev = prev / num;
                }

                sign = c;
                num = 0;
            }
        }
        result += prev +num;
        return result;
    }

    public static void main(String[] args) {
        LC227 obj = new LC227();
//        int res = obj.calculate2("1+2*3+4");
        int res = obj.calculate3(" 3/2 ");
        PrintUtils.printString("res:" + res);
    }
}
