package com.leetcode.Tree;

import com.leetcode.Helper.*;

public class LC117 {

    private static class Solution1 {
        public void connect(TreeLinkNode root) {
            if(root == null) {
                return;
            }

            TreeLinkNode prev = null;
            TreeLinkNode head = null;
            TreeLinkNode current = root;

            while(current != null) {
                while(current != null) {
                    if(current.left != null) {
                        if(prev != null) {
                            prev.next = current.left;
                        } else {
                            head = current.left;
                        }
                        prev = current.left;
                    }

                    if(current.right != null) {
                        if(prev != null) {
                            prev.next = current.right;
                        } else {
                            head = current.right;
                        }
                        prev = current.right;
                    }
                    current = current.next;
                }
                current = head;
                head = null;
                prev = null;
            }
        }
    }

    private static class Solution2 {
        public TreeLinkNode connect(TreeLinkNode root) {
            return dfs(root);
        }

        private TreeLinkNode dfs(TreeLinkNode node) {
            if (node != null) {
                if (node.left != null) {
                    node.left.next = node.right != null ? node.right : findNext(node.next); // find node.next's left or right
                }

                if (node.right != null) {
                    node.right.next = findNext(node.next);
                }

                dfs(node.left);
                dfs(node.right);
                return node;
            } else {
                return null;
            }
        }

        private TreeLinkNode findNext(TreeLinkNode node) {
            if (node == null) {
                return null;
            }

            TreeLinkNode ptr = node;
            while(ptr != null) {
                if (ptr.left != null) {
                    return ptr.left;
                }
                if (ptr.right != null) {
                    return ptr.right;
                }
                ptr = ptr.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
