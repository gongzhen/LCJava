package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 *
 * */
public class LC282 {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, target, 0, 0, 0, "");
        return res;
    }

    private void dfs(List<String> res, String num, int target, int idx, int sum, int prev, String str) {
        // PrintUtils.printString("sum:" + sum + "-> prev:" + prev + "-> str:" + str);
        if (idx == num.length() && sum == target) {
            res.add(str);
            return;
        }
        for(int i = idx; i < num.length(); i++) {
            String subNum = num.substring(idx, i + 1);
            int intNum = Integer.parseInt(subNum);
            if (idx == 0) {
                dfs(res, num, target, i+1, intNum, intNum, subNum);
            } else {
                dfs(res, num, target, i + 1,
                        sum + intNum, intNum, str + "+" + subNum);
                dfs(res, num, target, i + 1,
                        sum - intNum, -intNum, str + "-" + subNum);
                dfs(res, num, target, i + 1,
                        sum - prev + prev * intNum, prev * intNum, str + "*" + subNum);
            }
        }
    }

    public static void main(String[] args) {
        LC282 obj = new LC282();
        List<String> res = obj.addOperators("123", 6);
        PrintUtils.printListString(res);
    }
}
