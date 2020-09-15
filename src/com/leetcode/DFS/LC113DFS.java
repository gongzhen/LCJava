package com.leetcode.DFS;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class LC113DFS {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, list, 0, sum, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int current, int sum, TreeNode node) {
        if(node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val + current == sum) {
                list.add(node.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        list.add(node.val);
        dfs(res, list, current + node.val, sum, node.left);
        dfs(res, list, current + node.val, sum, node.right);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        LC113DFS obj = new LC113DFS();
        TreeNode root = TreeUtils.LC113createTree();
        List<List<Integer>> res = obj.pathSum(root, 22);
        PrintUtils.printListOfListInteger(res);
    }
}
