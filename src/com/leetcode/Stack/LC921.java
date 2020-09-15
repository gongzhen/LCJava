package com.leetcode.Stack;

import java.util.Stack;

public class LC921 {

    public int minAddToMakeValid(String S) {
        char[] array = S.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                st.push(array[i]);
            } else if (array[i] == ')') {
                if (st.isEmpty() == true) {
                    st.push(array[i]);
                } else {
                    char top = st.peek();
                    if (top == '(') {
                        st.pop();
                    } else {
                        st.push(array[i]);
                    }
                }
            }
        }

        return st.size();
    }


    public static void main(String[] args) {

    }
}
