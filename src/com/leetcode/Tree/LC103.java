package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        boolean zig = true;
        while(!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if(zig == true) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if(node.left != null) {
                    pq.offer(node.left);
                }
                if(node.right != null) {
                    pq.offer(node.right);
                }
            }
            zig = !zig;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
