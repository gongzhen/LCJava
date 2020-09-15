package com.leetcode.BitManipulation;

public class LC1318 {

    public int minFlips(int a, int b, int c) {
        // a = 2, b = 6, c = 5
        int res = 0;
        for(int i = 0; i < 30; i++) {
            int d1 = (a >> i) & 1;
            int d2 = (b >> i) & 1;
            int d3 = (c >> i) & 1;
            if (d3 == 0) {
                if (d1 == 1 && d2 == 0) {
                    res++;
                } else if (d1 == 0 && d2 == 1) {
                    res++;
                } else if (d1 == 1 && d2 == 1) {
                    res = res + 2;
                }
            } else if (d3 == 1) {
                if (d1 == 0 && d2 == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
