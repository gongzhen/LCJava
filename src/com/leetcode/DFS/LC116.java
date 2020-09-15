package com.leetcode.DFS;

import com.leetcode.Helper.NextNode;

public class LC116 {

    public NextNode connect(NextNode root) {
        return dfs(root);
    }

    private NextNode dfs(NextNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            node.left.next = node.right;
            if (node.next != null) {
                node.right.next = node.next.left;
            }
        }

        dfs(node.left);
        dfs(node.right);

        return node;
    }

    public static void main(String[] args) {
    }
}
