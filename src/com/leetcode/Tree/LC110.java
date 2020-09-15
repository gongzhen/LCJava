package com.leetcode.Tree;

import com.leetcode.Helper.*;

public class LC110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
