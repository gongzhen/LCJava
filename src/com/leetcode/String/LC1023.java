package com.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class LC1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // build tree for pattern
        List<Boolean> res = new ArrayList<>();
        if(queries.length == 0 || pattern.length() == 0) {
            return res;
        }
        for(String query : queries) {
            boolean match = stringMatch(query.toCharArray(), pattern.toCharArray());
            res.add(match);
        }
        return res;
    }

    private boolean stringMatch(char[] query, char[] pattern) {
        // FB
        // FooBar
        int j = 0;
        for(int i = 0; i < query.length; i++) {
            if (j < pattern.length && query[i] == pattern[j]) { // upper case
                j++;
            } else {
                if (query[i] >= 65 && query[i] <= 90) {
                    return false;
                }
            }
        }
        return j == pattern.length;
    }
    public static void main(String[] args) {

    }
}
