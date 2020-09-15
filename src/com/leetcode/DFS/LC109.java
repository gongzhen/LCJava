package com.leetcode.DFS;

import com.leetcode.Helper.ListNode;
import com.leetcode.Helper.PrintUtils;
import com.leetcode.Helper.TreeNode;

public class LC109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        int i = 0;
        while(ptr != null) {
            ptr = ptr.next;
            i++;
        }
        ListNode[] array = new ListNode[i];
        i = 0;
        ptr = head;
        while(ptr != null) {
            array[i++] = ptr;
            ptr = ptr.next;
        }
        return dfs(array, 0, i-1);
    }

    private TreeNode dfs(ListNode[] array, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            TreeNode node = new TreeNode(array[l].val);
            return node;
        }
        int mid = l + (r - l) / 2;
        TreeNode head = new TreeNode(array[mid].val);
        head.left = dfs(array, l, mid - 1);
        head.right = dfs(array, mid + 1, r);
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(-0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        LC109 obj = new LC109();
        TreeNode root = obj.sortedListToBST(n1);
        PrintUtils.printString("root:" + root.val);
    }
}
