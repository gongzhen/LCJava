package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.List;

public class LC95 {

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<>();
        }

        return dfs(1, n);
    }

    private List<TreeNode> dfs(int low, int high) {
        if(low > high) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        if(low == high) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(low));
            return list;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        for(int i = low; i <= high; i++) {
            List<TreeNode> left = dfs(low, i - 1);
            List<TreeNode> right = dfs(i + 1, high);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                    TreeUtils.printTree(root);
                    PrintUtils.printLine();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC95 obj = new LC95();
        // res:[1, 2, 3, 5, 7, 10]
        PrintUtils.printTreeNodeList(obj.generateTrees(3));
    }
}
