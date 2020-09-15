package com.leetcode.BFS;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                String word = queue.poll();
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char willReplace = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (willReplace != c) {
                            wordChars[i] = c;
                            String replacedWord = new String(wordChars);
                            if (wordSet.contains(replacedWord)) {
                                if (!visited.contains(replacedWord)) {
                                    visited.add(replacedWord);
                                    if (endWord.equals(replacedWord)) {
                                        return count;
                                    }
                                    queue.offer(replacedWord);
                                }
                            }
                        }
                    }
                    wordChars[i] = willReplace;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LC127 obj = new LC127();
        int res = obj.ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog")));
        PrintUtils.printString("res:" + res);
    }
}
