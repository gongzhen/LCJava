package com.leetcode.Array;

public class LC1051 {
    public int heightChecker(int[] heights) {
        int[] map = new int[101];
        for(int h: heights) {
            map[h]++;
        }

        int result = 0;
        int currentHeight = 0;
        int i = 0;
        for(int h : heights) {
            while(map[currentHeight] == 0) {
                currentHeight++;
            }

            if(currentHeight != heights[i]) {
                result++;
            }
            map[currentHeight]--;
            i++;
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
