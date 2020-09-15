package com.leetcode.Tree;

import com.leetcode.Helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // find node
        // find node's parent
        // if parent is null
        // then node is root
        // add node.left and node.right to res
        // check if parent is root
        // add node.left and node.right to resut
        // if parent is not root
        // add node.left and node.right to res, add root to result
        Set<Integer> deleteSet = new HashSet<>();
        for(int n : to_delete) {
            deleteSet.add(n);
        }

        List<TreeNode> res = new ArrayList<TreeNode>();
        if(deleteSet.contains(root.val) == false) {
            res.add(root);
        }
        dfs(res, deleteSet, root);
        return res;
    }

    private TreeNode dfs(List<TreeNode> res, Set<Integer> deleteSet, TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(res, deleteSet, node.left);
        node.right = dfs(res, deleteSet, node.right);
        if (deleteSet.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
