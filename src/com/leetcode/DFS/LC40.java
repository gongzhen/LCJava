package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        List<Integer> list = new ArrayList<>();
        dfs(res, list, target, 0, candidates, 0, visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int target, int sum, int[] candidates, int idx, boolean[] visited) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && visited[i-1] == false) {
                continue;
            }
            visited[i] = true;
            list.add(candidates[i]);
            dfs(res, list, target, sum + candidates[i], candidates, i + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;

        }
    }

    public static void main(String[] args) {
        LC40 obj = new LC40();
        List<List<Integer>> res = obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        PrintUtils.printListOfListInteger(res);
    }
}
