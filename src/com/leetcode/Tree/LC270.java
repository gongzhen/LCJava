package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

/**
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 *
 * */

public class LC270 {

    double[] res = new double[1];
    int max;

    public int closestValue(TreeNode root, double target) {
        res[0] = Integer.MAX_VALUE;;
        max = Integer.MAX_VALUE;
        dfs(root, target);
        return max;
    }

    public int bfs(TreeNode root, double target) {
        int min = root.val;
        while (root != null) {
            min = Math.abs(target - root.val) > Math.abs(target - min) ? min : root.val;
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return min;
    }

    private void dfs(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double diff = Math.abs((node.val * 1.00) - target);
        if (res[0] > diff) {
            res[0] = diff;
            max = node.val;
        }
        dfs(node.left, target);
        dfs(node.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.LC270createBSTTree();
        LC270 obj = new LC270();
        // int res = obj.closestValue(root, 3.714286);
        int res = obj.bfs(root, 3.714286);
        PrintUtils.printString("res:" + res);
    }
}
