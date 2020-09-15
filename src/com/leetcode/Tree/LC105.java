package com.leetcode.Tree;
import com.leetcode.Helper.*;


public class LC105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode dfs(int ps,
                        int pe,
                        int is,
                        int ie,
                        int[] preorder,
                        int[] inorder) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);

        int rootIdx = 0; // Index of current root in inorder
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.val) {
                rootIdx = i;
            }
        }

        root.left = dfs(ps + 1, pe, is, rootIdx - 1, preorder, inorder);
        // rootIdx - is is the left tree length
        // ps + (rootIdx - is) cross the root and left tree.
        // ps + (rootIdx - is) + 1 is the right tree of preorder.

        root.right = dfs(ps + rootIdx - is + 1, pe, rootIdx + 1, ie, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        LC105 obj = new LC105();
        TreeNode root = obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        // TreeUtils.printTree(root);
        TreeUtils.printTreeByLevel(root);
    }
}
