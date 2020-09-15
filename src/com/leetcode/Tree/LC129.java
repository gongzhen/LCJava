package com.leetcode.Tree;
import com.leetcode.Helper.*;



public class LC129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return node.val + sum * 10;
        }
        int n = node.val;
        int left = dfs(node.left, sum * 10 + n);
        int right = dfs(node.right, sum * 10 + n);
        return left + right;
    }

    public static void main(String[] args) {

    }
}
