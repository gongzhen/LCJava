package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

public class LC222 {

    private int dfs(TreeNode node) {
        return node == null ? -1 : 1 + dfs(node.left);
    }

    public int countNodes(TreeNode root) {
        int h = dfs(root);
        int nodes = 0;
        while (root != null) {
            if (dfs(root.right) == h - 1) {
                nodes += 1 << h; // 1 << h is h * h
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public int countNodesDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodesDFS(root.left);
        int right = countNodesDFS(root.right);
        return 1 + left + right;
    }

    public int countNodesDFS1(TreeNode root) {
        int hLeft = 0, hRight = 0;
        TreeNode pLeft = root, pRight = root;
        while (pLeft != null) {
            ++hLeft;
            pLeft = pLeft.left;
        }
        while (pRight != null) {
            ++hRight;
            pRight = pRight.right;
        }
        if (hLeft == hRight) {
            return (int)Math.pow(2, hLeft) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        LC222 obj = new LC222();
        TreeNode root = TreeUtils.LC270createBSTTree();
         int res = obj.countNodes(root);
//        int res = obj.countNodesDFS(root);
//        int res = obj.countNodesDFS1(root);
        PrintUtils.printString("res:" + res);
    }
}
