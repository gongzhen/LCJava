package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * */
public class LC113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, sum, res, list);
        return res;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> list) {
        if (node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            if (node.val == sum) {
                list.add(node.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(node.val);
        dfs(node.left, sum - node.val, res, list);
        dfs(node.right, sum - node.val, res, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        LC113 obj = new LC113();
        TreeNode root = TreeUtils.LC113createTree();
        List<List<Integer>> res = obj.pathSum(root, 22);
        PrintUtils.printListOfListInteger(res);
    }
}
