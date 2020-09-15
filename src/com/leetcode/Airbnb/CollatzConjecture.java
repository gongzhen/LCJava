package com.leetcode.Airbnb;

import java.util.HashMap;
import java.util.Map;

// https://github.com/allaboutjst/airbnb/tree/master/src/main/java
public class CollatzConjecture {

    private static int findSteps(int num, Map<Integer, Integer> map) {
        if (num <= 1) {
            return 1;
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        int result = 0;
        if (num % 2 == 0) {
            result =  findSteps(num / 2, map) + 1;
        } else {
            result = findSteps(3 * num + 1, map) + 1;
        }
        map.put(num, result);
        return result;
    }

    private static int findLongestSteps(int limit) {
        if (limit < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 1; i <= limit; i++) {
            longest = Math.max(longest, findSteps(i, map));
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSteps(10));
    }
}
