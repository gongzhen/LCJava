package com.leetcode.Tree;
import com.leetcode.Helper.*;
import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class LC145 {

    private static class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            if(root == null) {
                return new ArrayList<Integer>();
            }

            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> st = new Stack<TreeNode>();
            st.push(root);
            while(!st.isEmpty()) {
                TreeNode n = st.peek();
                if(n.left == null && n.right == null) {
                    list.add(n.val);
                    st.pop();
                }

                if (n.left != null){
                    st.push(n.left);
                    n.left = null;
                    continue;
                }
                if (n.right != null){
                    st.push(n.right);
                    n.right = null;
                    continue;
                }
            }
            return list;
        }
    }

    private static class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            if(root == null) {
                return new ArrayList<Integer>();
            }

            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> st = new Stack<TreeNode>();
            TreeNode ptr = root;
            TreeNode prev = null;
            while(ptr != null || !st.isEmpty()) {
                while(ptr != null) {
                    st.push(ptr);
                    ptr = ptr.left;
                }
                ptr = st.pop();
                if(ptr.right != null && prev != ptr.right) {
                    st.push(ptr);
                    ptr = ptr.right;
                } else {
                    list.add(ptr.val);
                    prev = ptr;
                    ptr = null;
                }
            }
            return list;
        }
    }

    private static class Solution3 {

        private static class Guide {
            int v;
            TreeNode node;
            public Guide(int v, TreeNode node) {
                this.v = v;
                this.node = node;
            }
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            Deque<Guide> dq = new ArrayDeque<>();
            dq.addFirst(new Guide(0, root));

            while(!dq.isEmpty()) {
                Guide current = dq.removeFirst();
                if(current.node == null) {
                    continue;
                }

                if(current.v == 1) {
                    list.add(current.node.val);
                } else {
                    dq.addFirst(new Guide(1, current.node));
                    dq.addFirst(new Guide(0, current.node.left));
                    dq.addFirst(new Guide(0, current.node.right));
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution1 obj = new Solution1();
        PrintUtils.printListInteger(obj.postorderTraversal(TreeUtils.LC145createTree()));
    }
}
