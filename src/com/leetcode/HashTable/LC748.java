package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] lowerCase = licensePlate.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : lowerCase) {
            if (c >= 'a' && c <= 'z') {
                if (map.containsKey(c)) {
                    int count = map.get(c);
                    map.put(c, ++count);
                } else {
                    map.put(c, 1);
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            Map<Character, Integer> copyMap = deelpCopy(map);
            for(char c : chars) {
                if (copyMap.containsKey(c)) {
                    int count = copyMap.get(c);
                    --count;
                    copyMap.put(c, count);
                    if (count == 0) {
                        copyMap.remove(c);
                    }
                }
            }
            if (copyMap.size() == 0 && word.length() < minLength) {
                result = word;
                minLength = word.length();
            }
        }
        return result;
    }

    private Map<Character, Integer> deelpCopy(Map<Character, Integer> original) {
        Map<Character, Integer> cloned = new HashMap<Character, Integer>();
        for(Character c : original.keySet()) {
            cloned.put(c, original.get(c));
        }
        return cloned;
    }

    public static void main(String[] args) {
        LC748 obj = new LC748();
        String res = obj.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        PrintUtils.printString("res:" + res);
    }
}
