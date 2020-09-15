package com.leetcode.TwoPointers;

import com.leetcode.Helper.PrintUtils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30 {

    /// https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13656/An-O(N)-solution-with-detailed-explanation
    private static class Solution1 {
        // fastest only 35 seconds
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if(words.length == 0 || s.length() < words.length * words[0].length()){
                return res;
            }
            Map<String, Integer> hm = new HashMap<>(), tempMap = new HashMap<>();
            for(String str : words){
                if(hm.containsKey(str)){
                    hm.put(str, hm.get(str) + 1);
                }else{
                    hm.put(str, 0);
                }
                // hm.put(str, hm.getOrDefault(str, 0) + 1);
            }
            int wl = words[0].length();
            int begin = 0, end = 0;
            for(int i = 0; i < wl; i++){
                int counter = 0;
                int wCounter = 0;
                begin = i; end = i;
                while(end + wl <= s.length()){
                    String str1 = s.substring(end, end + wl);
                    if(hm.containsKey(str1)){
                        if(tempMap.containsKey(str1)){
                            tempMap.put(str1, tempMap.get(str1) + 1);
                        }else{
                            tempMap.put(str1, 0);
                        }
                        if(tempMap.get(str1) <= hm.get(str1)) counter++;
                    }
                    end += wl;
                    wCounter++;
                    if(counter == words.length){
                        res.add(begin);
                    }
                    if(wCounter == words.length){
                        String temp = s.substring(begin, begin + wl);
                        if(hm.containsKey(temp)){
                            if(tempMap.get(temp) <= hm.get(temp)) counter--;
                            tempMap.put(temp, tempMap.get(temp)-1);
                        }
                        begin += wl;
                        wCounter--;
                    }
                }
                tempMap.clear();
            }
            return res;
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int total = words.length * words[0].length();
        int m = words.length;
        int n = words[0].length();
        for(int i = 0; i <= s.length() - total; i++) {
            int j = i;
            Map<String, Integer> copy = new HashMap<>(map);
            while(j <= s.length() - n) {
                String key = s.substring(j, j + n);
                if(!copy.containsKey(key) || copy.get(key) < 1) {
                    break;
                }

                copy.put(key, copy.get(key) - 1);
                if(copy.get(key) == 0) {
                    copy.remove(key);
                }
                if(copy.size() == 0) {
                    res.add(i);
                }
                j = j + n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC30 obj = new LC30();
        List<Integer> res = obj.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        PrintUtils.printListInteger(res);
    }
}
