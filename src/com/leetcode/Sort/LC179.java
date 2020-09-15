package com.leetcode.Sort;

import com.leetcode.Helper.Interval;
import com.leetcode.Helper.PrintUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC179 {

    public String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        int i = 0;
        for(int n : nums) {
            array[i++] = n;
        }
        Arrays.sort(array, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2) {
                String s1 = String.valueOf(n1);// 30
                String s2 = String.valueOf(n2);// 34
                String s11 = s1 + s2;
                String s22 = s2 + s1;
                return s22.compareTo(s11);
            }
        });

        StringBuilder sb = new StringBuilder();
        i = 0;
        boolean isZero = false;
        for(int n : array) {
            if (i++ == 0 && n == 0) {
                isZero = true;
            }
            if (isZero == true) { /// [0, 0] => 00 compare with 0
                return "0";
            }
            sb.append(n);
        }
        return sb.toString();
    }

    public String largestNumberDFS(int[] nums) {
        // for loop from 1 to n
        // start from 0, skip the current index of n, to last index
        // get all combination of rest numbers.
        // compare the result.
        for(int i = 0; i < nums.length; i++) {
            String str = "" + nums[i];
            for(int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                // no i==j
                List<String> list = new ArrayList<>();
                boolean[] visited = new boolean[nums.length];
                visited[i] = true;
                dfs(nums, i, "", list, visited, 0);
            }
        }

        return "";
    }

    private void dfs(int[] nums, int except, String sum, List<String> list, boolean[] visited, int start) {
        if (start + 1 == nums.length) {
            list.add(sum);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (i == except || visited[i] == true) {
                continue;
            }
            visited[i] = true;
            dfs(nums, except, sum + "" + nums[i], list, visited, start + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        LC179 obj = new LC179();
        String res = obj.largestNumber(new int[]{3,30,34,5,9});
        PrintUtils.printString("res:" + res);
    }
}
