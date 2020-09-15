package com.leetcode.Backtrack;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, list, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int position) {
        res.add(new ArrayList<>(list));

        for (int i = position; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC78 obj = new LC78();
        List<List<Integer>> res = obj.subsets(new int[]{1, 2, 3});
        PrintUtils.printListOfListInteger(res);
    }
}
