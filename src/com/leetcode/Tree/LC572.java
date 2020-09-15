package com.leetcode.Tree;

import com.leetcode.Helper.TreeNode;

public class LC572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return  dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

}
