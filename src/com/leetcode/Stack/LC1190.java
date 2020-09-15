package com.leetcode.Stack;

import java.util.Stack;

public class LC1190 {

    public String reverseParentheses(String s) {
        // (u(love)i)
        // (u(evol)i)
        // (i(love)u)
        Stack<Integer> st = new Stack<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (!st.isEmpty()) {
                    int j = st.pop();
                    // String substr = s.substring(j + 1, i);
                    reverse(array, j+1, i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == ')') {
                continue;
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }

    private void reverse(char[] array, int left, int right) {
        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
    }
}
