package com.leetcode.Tree;

import com.leetcode.Helper.*;

public class LC99 {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        // In order traversal to find the two elements
        dfs(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
        TreeUtils.printTree(root);
    }

    private void dfs(TreeNode root) {

        if (root == null)
            return;

        dfs(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        dfs(root.right);
    }

    public static void main(String[] args) {
        LC99 obj = new LC99();
        obj.recoverTree(TreeUtils.createTree());
    }
}
