package com.leetcode.HashTable;

import java.util.*;

public class LC500 {

    private static class Solution {
        public String[] findWords(String[] words) {
            String[] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i<strs.length; i++){
                for(char c: strs[i].toCharArray()){
                    map.put(c, i);//put <char, rowIndex> pair into the map
                }
            }
            List<String> res = new LinkedList<>();
            for(String w: words){
                if(w.equals("")) continue;
                int index = map.get(w.toLowerCase().charAt(0));
                int idx = 0;
                for(char c: w.toLowerCase().toCharArray()){
                    if(map.get(c)!=index){
                        break;
                    }
                    idx++;
                    if(idx == w.length()) {
                        res.add(w);//if index != -1, this is a valid string
                    }
                }
            }
            return res.toArray(new String[0]);
        }
    }

    public String[] findWords(String[] words) {
        String[] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new ArrayList<String>();
        for(String word : words) {
            String lower = word.toLowerCase();
            char ch = lower.charAt(0);
            for(String str : strs) {
                if(str.indexOf(ch) != -1) {
                    // str check all chars for word
                    int idx = 0;
                    for(char c : lower.toCharArray()) {
                        if(str.indexOf(c) == -1) {
                            break;
                        }
                        idx++;
                        if(idx == lower.length()) {
                            list.add(word);
                        }
                    }
                }
            }
        }
        String[] res = new String[list.size()];
        int idx = 0;
        for(String s : list) {
            res[idx++] = s;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
