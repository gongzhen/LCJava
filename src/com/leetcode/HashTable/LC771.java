package com.leetcode.HashTable;

public class LC771 {

    /*
    * 771. Jewels and Stones
    *
    */
    public int numJewelsInStones(String J, String S) {
        int[] map = new int[64];
        for(int i = 0; i < J.toCharArray().length; i++) {
            map[J.charAt(i) - 'A']++;
        }
        int count = 0;
        for(int i = 0; i < S.toCharArray().length; i++) {
            if(map[S.charAt(i) - 'A'] != 0 ) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
