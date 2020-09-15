package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, result, list, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int idx) {
        if (idx >= nums.length) {
            return;
        }
        result.add(new ArrayList<Integer>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, result, list, idx + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC90 obj = new LC90();
        List<List<Integer>> res1 = obj.subsetsWithDup(new int[]{1,2,2});
        PrintUtils.printListOfListInteger(res1);
    }
}
