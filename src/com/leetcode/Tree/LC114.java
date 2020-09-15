package com.leetcode.Tree;

import com.leetcode.Helper.*;


public class LC114 {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode rTree = root.right;
        TreeNode lTree = root.left;
        root.left = null;
        root.right = lTree;
        TreeNode ptr = root;
        while(ptr.right != null) {
            ptr = ptr.right;
        }
        ptr.right = rTree;
        flatten(root.right);
    }

    public static void main(String[] args) {

    }
}
