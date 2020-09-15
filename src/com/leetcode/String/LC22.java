package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class LC22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int open = 0;
        int close = 0;
        String str = "";
        DFS(list, open, close, n, str);
        return list;
    }

    public void DFS(List<String> list, int open, int close, int n, String str) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        if (open < n) {
            DFS(list, open + 1, close, n, str + "(");
        }

        if (close < open) {
            DFS(list, open, close + 1, n, str + ")");
        }
    }
    public static void main(String[] args) {
        LC22 obj = new LC22();
        List<String> res = obj.generateParenthesis(3);
        PrintUtils.printListString(res);
    }
}
