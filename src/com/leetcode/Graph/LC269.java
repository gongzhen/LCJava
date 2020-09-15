package com.leetcode.Graph;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 *
 *
 *
 * */

public class LC269 {

    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegreeMap = new HashMap<>();

        for(String word : words) {
            char[] wordChars = word.toCharArray();
            for(char c : wordChars) {
                inDegreeMap.put(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            int minLength = Math.min(current.length(), next.length());
            for(int j = 0; j < minLength; j++) {
                char currentChar = current.charAt(j);
                char nextChar = next.charAt(j);
                if (currentChar != nextChar) {
                    graph.putIfAbsent(currentChar, new HashSet<>());
                    Set<Character> hashSet = graph.get(currentChar);
                    if (!hashSet.contains(nextChar)) {
                        hashSet.add(nextChar);
                        graph.put(currentChar, hashSet);
                        inDegreeMap.put(nextChar, inDegreeMap.getOrDefault(nextChar, 0) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : inDegreeMap.keySet()) {
            int degree = inDegreeMap.get(c);
            if(degree == 0) {
                queue.offer(c);
            }
        }

        while(!queue.isEmpty()) {
            char curChar = queue.poll();
            sb.append(curChar);
            if (graph.containsKey(curChar)) {
                Set<Character> set = graph.get(curChar);
                for(char nextChar : set) {
                    inDegreeMap.put(nextChar, inDegreeMap.getOrDefault(nextChar, 0) - 1);
                    if(inDegreeMap.get(nextChar) == 0) {
                        queue.offer(nextChar);
                    }
                }
            }
        }

        if(sb.length() != inDegreeMap.size()) {
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC269 obj = new LC269();
        String res = obj.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        PrintUtils.printString("res:" + res);
    }
}
