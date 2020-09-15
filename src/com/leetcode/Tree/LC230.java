package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

import java.util.Stack;

public class LC230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = !stack.isEmpty() ? stack.pop() : null;
            k = k - 1;
            if (k == 0 && current != null) {
                return current.val;
            }

            if (current != null && current.right != null) {
                current = current.right;
                // stack.push(current);
            } else {
                current = null;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC230 obj = new LC230();
        TreeNode root = TreeUtils.LC230createBSTTree();
        int res = obj.kthSmallest(root, 5);
        PrintUtils.printString("res:" + res);
    }
}
