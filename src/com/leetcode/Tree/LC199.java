package com.leetcode.Tree;

import com.leetcode.Helper.*;

import java.util.ArrayList;
import java.util.List;


public class LC199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list, int level) {
        if(node ==  null) {
            return;
        }

        if(list.size() <= level) {
            list.add(node.val);
            return;
        }

        dfs(node.right, list, level + 1);
        dfs(node.left, list, level + 1);
    }

    public static void main(String[] args) {

    }
}
