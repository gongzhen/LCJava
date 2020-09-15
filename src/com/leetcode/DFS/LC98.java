package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

public class LC98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode node, TreeNode low, TreeNode high) {
        if(node == null) {
            return true;
        }
        if(low != null && node.val <= low.val) {
            return false;
        }
        if(high != null && node.val >= high.val) {
            return false;
        }
        // left branch: node's left -> node, node -> high
        // right branch: node's right -> node, node -> low
        return dfs(node.left, low, node) && dfs(node.right, node, high);
    }

    /*
    * (5, N, N)
    * -> (2, N, 5)
    * -> (1, N, 5)
    * -> (N, N, 1) && (N, 1, 2)
    *
    * */

    public static void main(String[] args) {
        LC98 obj = new LC98();
        TreeNode root = TreeUtils.createBSTTree();
        boolean res = obj.isValidBST(root);
        PrintUtils.printBool(res);
    }
}
