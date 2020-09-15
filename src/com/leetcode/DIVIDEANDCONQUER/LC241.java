package com.leetcode.DIVIDEANDCONQUER;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class LC241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String s1 = input.substring(0, i);
                String s2 = input.substring(i+1);
                List<Integer> part1 = diffWaysToCompute(s1);
                List<Integer> part2 = diffWaysToCompute(s2);
                for(Integer p1 : part1) {
                    for(Integer p2 : part2) {
                        int result = 0;
                        switch (c) {
                            case '+': result = p1 + p2;
                            break;
                            case '-': result = p1 - p2;
                            break;
                            case '*': result = p1 * p2;
                            break;
                        }
                        res.add(result);
                    }
                }
            }
        }
        if(0 == res.size()) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        LC241 obj = new LC241();
        List<Integer> res = obj.diffWaysToCompute("2*3-4*5");
        PrintUtils.printListInteger(res);
    }
}
