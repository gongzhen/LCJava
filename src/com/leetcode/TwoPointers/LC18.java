package com.leetcode.TwoPointers;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target1 = target - nums[i];
            threesum(nums, target1, res, i + 1, nums[i]);
        }
        return res;
    }

    private void threesum(int[] nums,
                          int target,
                          List<List<Integer>> res,
                          int start,
                          int first) {
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            int target2 = target - nums[i];
            twosum(nums, target2, res, i + 1, first, nums[i]);
        }
    }

    private void twosum(int[] nums,
                        int target,
                        List<List<Integer>> res,
                        int start,
                        int first,
                        int second) {
        int i = start, j = nums.length - 1;
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(second);
                list.add(nums[i]);
                list.add(nums[j]);
                res.add(new ArrayList<>(list));
                i++;
                j--;
                while(i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while(i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        LC18 obj = new LC18();
        List<List<Integer>> res = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        PrintUtils.printListOfListInteger(res);
    }
}
