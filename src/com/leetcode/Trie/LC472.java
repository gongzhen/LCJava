package com.leetcode.Trie;

import java.util.List;

public class LC472 {

    class Trie{
        Trie[] next = new Trie[26];
        String word = null;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            if (word.length() == 0) {
                continue;
            }

        }
        return null;
    }

    private void addWord(String word, Trie root) {
        
    }

    public static void main(String[] args) {
        LC472 obj = new LC472();
        List<String> res = obj.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
    }
}
