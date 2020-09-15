package com.leetcode.DFS;

import com.leetcode.Helper.NextNode;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

public class LC117DFS {

    public NextNode connect(NextNode root) {
        return dfs(root);
    }

    private NextNode dfs(NextNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            node.left.next = node.right != null ? node.right : findNext(node.next);
        }
        if (node.right != null) {
            node.right.next = findNext(node.next);
        }
        dfs(node.left);
        dfs(node.right);
        return node;
    }

    private NextNode findNext(NextNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        }
        if (node.right != null) {
            return node.right;
        }
        return findNext(node.next);
    }

    public static void main(String[] args) {
        NextNode node = TreeUtils.LC117createTree();
        LC117DFS obj = new LC117DFS();
        obj.connect(node);
        TreeUtils.dfs117(node);
    }
}
