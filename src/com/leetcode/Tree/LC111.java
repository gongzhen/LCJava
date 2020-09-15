package com.leetcode.Tree;

import com.leetcode.Helper.*;


public class LC111 {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // you need these to handle
        //          2
        //        3
        else if (root.left == null) {
            return minDepth(root.right)  +1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
