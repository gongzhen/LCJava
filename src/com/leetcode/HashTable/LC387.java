package com.leetcode.HashTable;

public class LC387 {

    public int firstUniqChar(String s) {
        if(s.length() == 0) {
            return -1;
        }
        int[] map = new int[64];
        char [] array = s.toCharArray();
        for(int i = 0 ; i < array.length; i++) {
            map[array[i] - 'A']++;
        }
        for(int i = 0; i < array.length; i++) {
            if(map[array[i] - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
