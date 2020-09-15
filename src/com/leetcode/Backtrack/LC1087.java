package com.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC1087 {

    public String[] expand(String S) {
        if (S.length() == 0) {
            return new String[]{""};
        }

        List<String> list = new ArrayList<String>(0);

        int start = 0;
        char[] array = S.toCharArray();
        for (int j = 0; j < array.length; j++) {
            char c = array[j];
            if (c == '{') {
                if (j == 0) {
                    start = j + 1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    for(int k = start; k < j; k++) {
                        if (S.charAt(k) == ',') {
                            continue;
                        }
                        sb.append(S.charAt(k));
                    }
                    start = j + 1;
                    list.add(sb.toString());
                }
            } else if (c == '}'){
                StringBuilder sb = new StringBuilder();
                for(int k = start; k < j; k++) {
                    if (S.charAt(k) == ',') {
                        continue;
                    }
                    sb.append(S.charAt(k));
                }
                start = j + 1;
                list.add(sb.toString());
            }
        }
        if (start < S.length()) {
            String substr = S.substring(start);
            list.add(substr);
        }
        if (list.size() == 1) {
            return new String[]{list.get(0)};
        }
        List<String> arrayList = new ArrayList<>();

        dfs(list, arrayList, 0, "");

        String[] res = new String[arrayList.size()];
        int i = 0;
        for(String w : arrayList) {
            res[i++] = w;
        }
        return res;
    }

    private void dfs(List<String> list, List<String> arrayList, int idx, String sb) {
        if (idx == list.size()) {
            arrayList.add(sb);
            return;
        }

        String word = list.get(idx);
        for(char c : word.toCharArray()) {
            dfs(list, arrayList, idx + 1, sb + c);
        }
    }

    public static void main(String[] args) {
        LC1087 obj = new LC1087();
        // obj.expand("{a,b}c{d,e}f");
        // obj.expand("abcd");
        // obj.expand("k{a,b,c,d,e,f,g}");
        // obj.expand("{a}{a}{a}");
        obj.expand("{a,b}");
        // "{a}{a}{a}"
        // "k{a,b,c,d,e,f,g}"
        // ab, c, de, f
        // 0 -> word: ab  sb = ""
        // dfs(1, a)
        // sb: a
        // 1 -> c
        // dfs(2, ac)
        // word : de
        // dfs(3, acd)
        // word : f
        // dfs(4, acdf)
        // arryList.add(acdf)
    }
}
