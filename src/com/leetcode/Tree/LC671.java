package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;
import jdk.nashorn.api.tree.Tree;

public class LC671 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            // return  root.val;
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;
        if (root.val == root.left.val) {
            left = findSecondMinimumValue(root.left);
        }

        if (root.val == root.right.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left == -1) {
            return right;
        } else {
            return left;
        }
    }

//    public int findSecondMinimumValue(TreeNode root) {
//        if (root == null) {
//            return -1;
//        }
//        return dfs(root, root.val);
//    }

    public int dfs(TreeNode node, int v) {
        if (node == null) {
            return -1;
        }
        if (node.val > v) {
            return node.val;
        }

        int left = dfs(node.left, v);
        int right = dfs(node.right, v);

        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        }
        return Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode root = TreeUtils.LC671createTree();
        LC671 obj = new LC671();
        int res = obj.findSecondMinimumValue(root);
        PrintUtils.printString("res:" + res);
    }
}
