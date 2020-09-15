package com.leetcode.Tree;

import com.leetcode.Helper.*;

public class LC124 {

    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        LC124 obj = new LC124();
        PrintUtils.printString("res:" + obj.maxPathSum(TreeUtils.LC124createTree()));
    }
}
