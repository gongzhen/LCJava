package com.leetcode.BFS;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;
import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class LC863 {

    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    private void buildGraph(TreeNode parent, TreeNode child) {
        if (parent != null && child != null) {
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<TreeNode>());
            }
            if (child.left != null) {
                map.get(child).add(child.left);
            }
            if (child.right != null) {
                map.get(child).add(child.right);
            }
            map.get(child).add(parent);
        } else if (parent != null){
            // return;
        } else if (child != null) {
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<TreeNode>());
            }
            if (child.left != null) {
                map.get(child).add(child.left);
            }
            if (child.right != null) {
                map.get(child).add(child.right);
            }
        }
        if (child != null) {
            buildGraph(child, child.left);
            buildGraph(child, child.right);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        // build graph
        buildGraph(null, root);

        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode node = findNode(root, target);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        visited.add(node);
        int k = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                visited.add(pop);
                if (k == K) {
                    res.add(pop.val);
                }
                for(TreeNode child : map.get(pop)) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.offer(child);
                }
            }
            k++;
        }
        return res;
    }

    private TreeNode findNode(TreeNode node, TreeNode target) {
        if(node == null) {
            return null;
        }
        if (node.val == target.val) {
            return node;
        }
        TreeNode left = findNode(node.left, target);
        TreeNode right = findNode(node.right, target);
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Map<TreeNode, TreeNode> pair = TreeUtils.LC863createTree();
        LC863 obj = new LC863();
        for(TreeNode key: pair.keySet()){
            TreeNode root = key;
            TreeNode target = pair.get(key);
            List<Integer> res = obj.distanceK(root, target, 2);
            PrintUtils.printListInteger(res);
        }
    }
}
