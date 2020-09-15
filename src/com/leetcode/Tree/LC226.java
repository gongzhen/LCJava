package com.leetcode.Tree;
import com.leetcode.Helper.*;

public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {

    }
}
