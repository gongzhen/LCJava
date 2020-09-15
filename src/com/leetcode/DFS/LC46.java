package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class LC46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(res, list ,nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC46 obj = new LC46();
        List<List<Integer>> res = obj.permute(new int[]{4, 7, 5, 1, 2, 3});
        // PrintUtils.printListOfListInteger(res);
        // google part
        List<List<Integer>> gRes = new ArrayList<>();
        int i = 0; // 0, 1, 2, == 3, 4, 5
        for(List<Integer> list : res) {
            if (obj.validArray(list) == true) {
                gRes.add(list);
            }
        }
        PrintUtils.printListOfListInteger(gRes);
    }

    private boolean validArray(List<Integer> list) {
        if (list.size() == 0) {
            return false;
        }
        int size = list.size();
        int i = 1;
        while (i < size) {
            if (i == size / 2) {
                continue;
            }
            if (list.get(i-1) > list.get(i)) {
                return false;
            }
            i++;
        }
        i = 0;
        while (i < size / 2) {
            if (list.get(i) < list.get(i + size / 2)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
