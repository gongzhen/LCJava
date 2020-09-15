package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<List<Integer>> list, TreeNode node, int level) {
        if(node == null) {
            return;
        }

        if(level >= list.size()) {
            list.add(0, new ArrayList<Integer>());
        }
        dfs(list, node.left, level + 1);
        dfs(list, node.right, level + 1);
        list.get(list.size() - level - 1).add(node.val);
    }


    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.isEmpty()!= true) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i =0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(0, new ArrayList<Integer>(list));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
