package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

public class LC1055 {

    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        boolean[] map = new boolean[26];
        for (int i = 0; i < cs.length; i++)
            map[cs[i] - 'a'] = true;
        int j = 0, res = 1;
        for (int i = 0; i < ts.length; i++,j++) {
            if (!map[ts[i] - 'a']) return -1;
            while (j < cs.length && cs[j] != ts[i]) {
                j++;
            }
            if (j == cs.length) {
                j = -1;
                res++;
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1055 obj = new LC1055();
        int res = obj.shortestWay("abc", "abcbc");
        PrintUtils.printString("res:" + res);
        res = obj.shortestWay("abc", "acdbc");
        PrintUtils.printString("res:" + res);
        res = obj.shortestWay("xyz", "xzyxz");
        PrintUtils.printString("res:" + res);
    }
}
