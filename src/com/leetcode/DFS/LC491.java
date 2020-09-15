package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC491 {

    public List<List<Integer>> findSubsequencesSet(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        dfs1(set, list, nums, 0);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        PrintUtils.printHashSetOfLinkedListInteger(set);
        for(List subset: set) {
            result.add(new ArrayList<Integer>(subset));
        }
        return result;
    }

    private void dfs1(Set<List<Integer>> set, List<Integer> list, int[] nums, int idx) {
        if(list.size() >= 2) {
            set.add(new ArrayList<Integer>(list));
        }

        for(int i = idx; i < nums.length; i++) {
            if(list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                dfs1(set, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        // ascending order nums
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, list, nums, 0, visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int idx, boolean[] visited) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }

        for(int i = idx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) {
                continue;
            }
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(res, list, nums, i + 1,visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LC491 obj = new LC491();
        List<List<Integer>> res = obj.findSubsequences(new int[]{4, 6, 7, 7, 4});
        PrintUtils.printListOfListInteger(res);
        res.clear();
//        res = obj.findSubsequences(new int[]{7, 6, 5, 4});
//        List<List<Integer>>
        res = obj.findSubsequencesSet(new int[]{4, 6, 7, 7, 4});
        PrintUtils.printListOfListInteger(res);
        /**
         *
         * [4, 4, ]
         * [7, 7, ]
         * [6, 7, ]
         * [4, 6, ]
         * [4, 6, 7, 7, ]
         * [4, 7, 7, ]
         * [4, 6, 7, ]
         * [4, 7, ]
         * [6, 7, 7, ]
         *
         * [4, 4, ]
         * [7, 7, ]
         * [6, 7, ]
         * [4, 6, ]
         * [4, 6, 7, 7, ]
         * [4, 7, 7, ]
         * [4, 6, 7, ]
         * [4, 7, ]
         * [6, 7, 7, ]
         *
         */

    }
}
