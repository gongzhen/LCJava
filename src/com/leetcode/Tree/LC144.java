package com.leetcode.Tree;
import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class LC144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode ptr = st.pop();
            list.add(ptr.val);
            if(ptr.right != null) {
                st.push(ptr.right);
            }

            if (ptr.left != null){
                st.push(ptr.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
