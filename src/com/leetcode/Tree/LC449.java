package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;
import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append(root.val).append(",");
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                sb.append(node.left.val).append(",");
                queue.offer(node.left);
            } else {
                sb.append(",");
            }

            if (node.right != null) {
                sb.append(node.right.val).append(",");
                queue.offer(node.right);
            } else {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Encodes a tree to a single string.
    public String serialize_1(TreeNode root) {
        if(root == null) {
            return null;
        }
        //    5
        // 1     3
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ","); // sb: 5,
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left); // 1
                sb.append(node.left.val + ","); // 5, 1,
            } else {
                sb.append(",");
            }

            if(node.right != null) { // 5, 1, 3, "", "", "", ""
                queue.offer(node.right);
                sb.append(node.right.val + ",");
            } else {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        PrintUtils.printStringArray(array);
        if(array == null || array.length == 0) {
            return null;
        }
        int rootNumber = Integer.parseInt(array[0]);
        TreeNode root = new TreeNode(rootNumber);

        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < array.length && array[i].equals("") == false) {
                int nodeNumber = Integer.parseInt(array[i]);
                TreeNode leftNode = new TreeNode(nodeNumber);
                node.left = leftNode;
                queue.offer(leftNode);
            }
            i++;
            if (i < array.length && array[i].equals("") == false) {
                int nodeNumber = Integer.parseInt(array[i]);
                TreeNode rightNode = new TreeNode(nodeNumber);
                node.right = rightNode;
                queue.offer(rightNode);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        LC449 obj = new LC449();
        TreeNode root = TreeUtils.createTree();
        String str = obj.serialize(root);
        PrintUtils.printString("str:" + str);
        str = obj.serialize_1(root);
        PrintUtils.printString("str:" + str);
        TreeNode node = obj.deserialize(str);
        TreeUtils.printTreeByLevel(node);
    }
}
