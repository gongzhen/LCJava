package com.leetcode.Array;

import java.util.Stack;

public class LC84 {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        int res = 0;
        int i = 0;
        while(i <= heights.length) {
            int h = (i == heights.length) ? 0 : heights[i];
            while(!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];
                int start = st.isEmpty() == true ? -1 : st.peek();
                res = Math.max(res, height * (i - start - 1));
            }
            st.push(i);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
