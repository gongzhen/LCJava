package com.leetcode.Tree;

import com.leetcode.Helper.*;


public class LC112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        } else if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        return dfs(node.left, sum - node.val) || dfs(node.right, sum - node.val);
    }


    public static void main(String[] args) {
        LC112 obj = new LC112();
        // res:[1, 2, 3, 5, 7, 10]
        PrintUtils.printString("res:" + obj.hasPathSum(TreeUtils.LC112createTree(), -5));
    }
}
