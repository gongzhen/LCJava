package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.Helper.*;
import jdk.nashorn.api.tree.Tree;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * */
public class LC94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }

        // dfs(root, list);

        TreeNode ptr = root;
        Stack<TreeNode> st = new Stack<>();

        while (ptr != null || !st.isEmpty()) {
            while (ptr != null) {
                st.push(ptr);
                ptr = ptr.left;
            }
            ptr = st.pop();
            list.add(ptr.val);
            ptr = ptr.right;
        }

        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    public static void main(String[] args) {
        LC94 obj = new LC94();
        // res:[1, 2, 3, 5, 7, 10]
        PrintUtils.printString("res:" + obj.inorderTraversal(TreeUtils.createBSTTree()));

    }
}
