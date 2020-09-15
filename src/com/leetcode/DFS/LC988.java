package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

public class LC988 {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
/**
 *
 *         //       c
 *         //    c      b
 *         //   N b    a N
 *         //    a
 * */
    private String dfs(TreeNode node, String sb) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            char c = (char)(node.val + 'a');
            return c + sb;
        }
        char c = (char)((int)('a') + node.val);
        String left = dfs(node.left, c + sb);
        String right = dfs(node.right, c + sb);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        int res = left.compareTo(right);
        if (res > 0) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        LC988 obj = new LC988();
        TreeNode root = TreeUtils.LC988createBSTTree();
        String res = obj.smallestFromLeaf(root);
        PrintUtils.printString("res:" + res);
    }
}
