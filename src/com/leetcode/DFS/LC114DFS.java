package com.leetcode.DFS;

import com.leetcode.Helper.TreeNode;

public class LC114DFS {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode leftTree = node.left;
        TreeNode rightTree = node.right;
        node.right = leftTree;
        node.left = null;
        dfs(node.right);
        TreeNode mostRightNode = mostRight(node);
        mostRightNode.right = rightTree;
        dfs(mostRightNode.right);
    }

    private TreeNode mostRight(TreeNode node)  {
        if(node == null) {
            return null;
        }
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }
}
