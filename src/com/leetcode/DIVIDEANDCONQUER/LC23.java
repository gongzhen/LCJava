package com.leetcode.DIVIDEANDCONQUER;

import com.leetcode.Helper.ListNode;
import com.leetcode.Helper.PrintUtils;

public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {
        // binary merge from 0 to length
        if (lists.length == 0) {
            return null;
        }

        return binaryMerge(lists, 0, lists.length - 1);
    }

    private ListNode binaryMerge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        } else if (l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;
        ListNode left = binaryMerge(lists, l, mid);
        ListNode right = binaryMerge(lists, mid + 1, r);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        ListNode head = new ListNode(0);
        ListNode ptr = head;

        while(left != null && right != null) {
            if (left.val == right.val) {
                ptr.next = left;
                left = left.next;
                ptr = ptr.next;
                ptr.next = right;
                right = right.next;

                // L 1 - 3 - 4
                // R 1 - 5 - 6
                // ptr.next:1 ->
                // ptr:1 -> 1
            } else if (left.val < right.val) {
                ptr.next = left;
                left = left.next;
            } else if (left.val > right.val) {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }

        if (left != null) {
            ptr.next = left;
        } else if (right != null) {
            ptr.next = right;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n11 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n44 = new ListNode(4);
        ListNode n2= new ListNode(2);
        ListNode n6 = new ListNode(6);
        n1.next = n4;n4.next = n5;
        n11.next = n3; n3.next = n44;
        n2.next = n6;
        ListNode[] input = new ListNode[]{n1, n11, n2};
        LC23 obj = new LC23();
        ListNode res = obj.mergeKLists(input);
        PrintUtils.printString("res:" + res.val);
    }
}
