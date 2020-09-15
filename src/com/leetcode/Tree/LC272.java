package com.leetcode.Tree;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;
import com.leetcode.Helper.TreeUtils;

import java.util.*;

public class LC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // INORDER
        // create stack to in-order traverse
        // queue offer(
        Queue<Integer> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;
        while(current != null || stack.isEmpty() == false) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(queue.size() < k) {
                queue.offer(current.val);
            } else {
                if(Math.abs(queue.peek() - target) > Math.abs(current.val - target)) {
                    queue.poll();
                    queue.offer(current.val);
                } else {
                    break;
                }
            }
            current = current.right;
        }
        for(int n : queue) {
            res.add(n);
        }
        return res;
    }

    public static void main(String[] args) {
        LC272 obj = new LC272();
        TreeNode root = TreeUtils.createBSTTree();
        List<Integer> res = obj.closestKValues(root, 3.714286, 2);
        PrintUtils.printString("res:" + res);
    }
}
