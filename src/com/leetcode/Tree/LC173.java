package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.Stack;

public class LC173 {

    private static class BSTIterator {

        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            pushAllLeft(root);
        }

        private void pushAllLeft(TreeNode node) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            if(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node.right != null) {
                    pushAllLeft(node.right);
                }
                return node.val;
            }
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
