package com.leetcode.Tree;

import com.leetcode.Helper.*;


public class LC106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode dfs(int[] inorder,
                         int is, int ie,
                         int[] postorder,
                         int ps, int pe) {
        if(is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int rootIdx = -1;
        for(int i = is; i <= ie; ++i) {
            if(root.val == inorder[i]) {
                rootIdx = i;
            }
        }

        /* inorder left: 9, root: 3  postorder: 9, */
        root.left = dfs(inorder, is, rootIdx - 1, postorder, ps,  ps + rootIdx - is - 1);
        // inorder right: 15, 20, 7    root: 3   postorder: 15, 7 20
        root.right = dfs(inorder, rootIdx + 1, ie, postorder, ps + rootIdx - is, pe - 1);
        return root;
    }

    public static void main(String[] args) {
        LC106 obj = new LC106();
        TreeNode root = obj.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        // TreeUtils.printTree(root);
        TreeUtils.printTreeByLevel(root);
    }
}
