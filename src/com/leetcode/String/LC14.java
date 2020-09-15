package com.leetcode.String;

public class LC14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean isFound = false;
        while(!isFound) {
            char c = ' ';
            for(String str: strs) {
                if(str.isEmpty() == true || idx >= str.length()) {
                    isFound = true;
                    break;
                }
                char current = str.charAt(idx);
                if (c == ' ') {
                    c = current;
                } else if (c != current) {
                    isFound = true;
                    break;
                }
            }
            if (c == ' ') {
                isFound = true;
            }
            if(!isFound) {
                sb.append(c);
                idx++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
