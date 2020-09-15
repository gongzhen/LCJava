package com.leetcode.DFS;

import com.leetcode.Helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC337 {

    public int rob(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(root, map);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        int current = 0;
        if (node.left != null) {
            current += dfs(node.left.left, map) + dfs(node.left.right, map);
        }
        if (node.right != null) {
            current += dfs(node.right.left, map) + dfs(node.right.right, map);
        }

        int max = Math.max(current + node.val, dfs(node.left, map) + dfs(node.right, map));
        map.put(node.val, max);
        return max;
    }

    public static void main(String[] args) {

    }
}
