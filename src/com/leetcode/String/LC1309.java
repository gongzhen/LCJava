package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC1309 {

    public String freqAlphabets(String s) {
// Characters ('a' to 'i') are represented by ('1' to '9') respectively.
        // Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
        Map<String, Character> map = new HashMap<>();
        int numInt = 1;
        for(char i = 'a'; i <= 'z'; i++) {
            String numStr = Integer.toString(numInt);
            map.put(numStr, i); // 1 -> a, 2 -> b, 3 -> c, 4 -> d, 5 -> e, 6 -> f
            numInt += 1;
        }

        // "10#11#12"
        // 10, 11, 12
        // "1326#"
        // 1, 3, 26
        // a  c  z
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            int index = s.indexOf("#", i);
            if (index != -1 && index != i) {
                String num = s.substring(i, index);
                if (map.containsKey(num)) {
                    char c = map.get(num);
                    sb.append(c);
                } else {
                    int j = 0;
                    while(j < num.length()) {
                        char charKey = num.charAt(j);
                        String key = String.valueOf(charKey);
                        char value = map.get(key);
                        sb.append(value);
                        j++;
                        String restKey = num.substring(j);
                        if (map.containsKey(restKey)) {
                            char restValue = map.get(restKey);
                            sb.append(restValue);
                            break;
                        }
                    }
                }
                i = index + 1;
            } else if (index == -1) {
                String num = s.substring(i);
                int j = 0;
                while ( j < num.length()) {
                    char charKey = num.charAt(j);
                    String key = String.valueOf(charKey);
                    char value = map.get(key);
                    sb.append(value);
                    j++;
                }
                break;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC1309 obj = new LC1309();
        String res = obj.freqAlphabets("10#11#12");
        PrintUtils.printString("res:" + res);
    }
}
