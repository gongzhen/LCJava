package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class LC39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        dfs(res, list, target, 0, candidates, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int target, int sum, int[] nums, int idx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, list, target, sum + nums[i], nums, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC39 obj = new LC39();
        List<List<Integer>> res = obj.combinationSum(new int[]{2, 3, 6, 7}, 7);
        PrintUtils.printListOfListInteger(res);
    }
}
