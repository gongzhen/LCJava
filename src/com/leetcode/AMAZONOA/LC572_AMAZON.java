package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

/**
 *
 Subtree: Maximum Average Node
 Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 Example Given a binary tree:


        2 ​
     /     \
  -2       14
  / \      / \
 -1  1     5  -1


 return the node 14.

 * */
public class LC572_AMAZON {

    public int maxSum;
    private TreeNode maxNode;

    public TreeNode maxSumAverageNode(TreeNode s) {
        maxSum = 0;
        maxNode = null;
        dfs(s);
        return maxNode;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        int sum = sumOfTree(node);
        int num = numberOfNodes(node);
        if (maxSum < sum / num) {
            maxSum = sum / num;
            maxNode = node;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public int sumOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumOfTree(node.left) + sumOfTree(node.right);
    }

    public int numberOfNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
    }

    /*
    *
    * Solution 2
    *
    */

    private static class Pair{
        int sum;
        int count;
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    public TreeNode maxSumAverageNode2(TreeNode s) {
        maxNode = null;
        Pair p = dfs2(s);
        return maxNode;
    }

    public Pair dfs2(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair left = dfs2(node.left);
        Pair right = dfs2(node.right);
        if(maxSum < (node.val + left.sum + right.sum) / (1 + left.count + right.count)) {
            maxSum = (node.val + left.sum + right.sum) / (1 + left.count + right.count);
            maxNode = node;
        }
        return new Pair(node.val + left.sum + right.sum, 1 + left.count + right.count);
    }

    public static void main(String[] args) {
        LC572_AMAZON obj = new LC572_AMAZON();
        TreeNode node = TreeUtils.LC572_AMAZON_createTree();
        TreeNode result = obj.maxSumAverageNode2(node);
        PrintUtils.printString("node:" + result.val);
    }
}
