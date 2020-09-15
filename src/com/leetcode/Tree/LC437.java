package com.leetcode.Tree;

import com.leetcode.Helper.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * */

public class LC437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

//    public int pathSumWithMap(TreeNode root, int sum) {
//        Map<Integer, Integer> map = new HashMap<>();
//
//    }

    private int dfs(TreeNode node, int sum, int current) {
        if (node == null) {
            return 0;
        }
        current += node.val;
        return current == sum ? 1 : 0 + dfs(node.left, sum, current) + dfs(node.right, sum, current);
    }

    public static void main(String[] args) {

    }
}
