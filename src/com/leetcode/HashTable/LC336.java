package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC336 {

    private static class Solution1 {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for(int i = 0; i < words.length; i++) {
                for(int j = i + 1; j < words.length; j++) {
                    if(palindrome(words[i] + words[j])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                    if( words[i] + words[j]  != words[j] + words[i] && palindrome(words[j] + words[i])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        res.add(list);
                    }
                }
            }
            return res;
        }

        private boolean palindrome(String s) {
            if(s == null) {
                return false;
            }
            int i = 0, j = s.length() - 1;
            while(i < j) {
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    private static class Solution2 {

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if (words == null || words.length < 2) {
                return res;
            }

            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i=0; i<words.length; i++) {
                map.put(words[i], i);
            }

            for (int i=0; i<words.length; i++) {
                for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                    String str1 = words[i].substring(0, j);
                    String str2 = words[i].substring(j);
                    if (palindrome(str1)) {
                        String str2rvs = new StringBuilder(str2).reverse().toString();
                        if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(map.get(str2rvs));
                            list.add(i);
                            res.add(list);
                        }
                    }
                    if (palindrome(str2)) {
                        String str1rvs = new StringBuilder(str1).reverse().toString();
                        // check "str.length() != 0" to avoid duplicates
                        if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(i);
                            list.add(map.get(str1rvs));
                            res.add(list);
                        }
                    }
                }
            }
            return res;
        }

        private boolean palindrome(String s) {
            if(s == null) {
                return false;
            }
            int i = 0, j = s.length() - 1;
            while(i < j) {
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

    }


    public static void main(String[] args) {
        Solution2 obj = new Solution2();
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> res = obj.palindromePairs(words);
        PrintUtils.printListOfListInteger(res);
    }
}
