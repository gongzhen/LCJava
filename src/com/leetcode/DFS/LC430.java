package com.leetcode.DFS;

import com.leetcode.Helper.ChildNode;
import com.leetcode.Helper.LinkedListUtils;
import com.leetcode.Helper.PrintUtils;

public class LC430 {

    public ChildNode flatten(ChildNode head) {

        ChildNode ptr = head;
        while(ptr != null) {
            if (ptr.child == null) {
                ptr = ptr.next;
            } else {
                ChildNode childBranch = ptr.child;
                ChildNode nextBranch = ptr.next;
                //
//                ptr.next = flatten(childBranch);
//                ptr.next.prev = ptr;
//
//                ptr.child = null;
//
//                while(ptr.next != null) {
//                    ptr = ptr.next;
//                }
//
//                if (nextBranch != null) {
//                    ptr.next = nextBranch;
//                    ptr.next.prev = ptr;
//                }
//                ptr = ptr.next;

                // without dfs
                ptr.next = childBranch;
                ptr.next.prev = ptr;
                ptr.child = null;
                // find the end
                ChildNode findEnd = ptr.next;
                ChildNode prev = ptr;
                while(findEnd != null) {
                    prev = findEnd;
                    findEnd = findEnd.next;
                }
                if (nextBranch != null) {
                    prev.next = nextBranch;
                    prev.next.prev = prev;
                }
                ptr = ptr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ChildNode head = LinkedListUtils.createLC430ChildLinkedList();
        LC430 obj = new LC430();
        ChildNode res = obj.flatten(head);
        LinkedListUtils.printChildNodeLinkedList(res);
    }
}
