package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;
import jdk.nashorn.api.tree.Tree;

public class LC156 {

    // https://blog.csdn.net/whuwangyi/article/details/43186045
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        // put the root's left as new root
        // put the root become newRoot's right,
        // put the root's right become new root's left
        return dfs(root);
        // return bfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode parent = node;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null) {
            TreeNode leftBecomeRoot = dfs(left);
            left.left = right;
            left.right = parent;
            return leftBecomeRoot;
        }
        return node;
    }

    private TreeNode bfs(TreeNode root) {
        TreeNode node  = root;
        TreeNode parent = null;
        TreeNode right = null;
        while (node != null) {
            TreeNode nodeLeft = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = nodeLeft;
            TreeUtils.printTreePretty(parent);
        }
        return parent;
    }

    public static void main(String[] args) {
        LC156 obj = new LC156();
        TreeNode root = TreeUtils.LC156createTree();
        TreeUtils.printTreePretty(root);
        TreeNode res = obj.UpsideDownBinaryTree(root);
//        TreeUtils.printTreePretty(res);
        PrintUtils.printString("res:" + res.val);
        TreeUtils.printTreeByLevel(res);
//        TreeUtils.printTreePretty(res);
    }
}
