package com.leetcode.Helper;

public class LinkedListUtils {

    public static void printChildNodeLinkedList(ChildNode node) {
        if (node == null) {
            return;
        }

        ChildNode ptr = node;
        while(ptr != null) {
            PrintUtils.printStringWithoutNewLine("" + ptr.val + " - ");
            ptr = ptr.next;
        }
    }

    public static ChildNode createLC430ChildLinkedList() {
        ChildNode node1 = new ChildNode(1, null, null, null);
        ChildNode node2 = new ChildNode(2, null, null, null);
        ChildNode node3 = new ChildNode(3, null, null, null);
        ChildNode node4 = new ChildNode(4, null, null, null);
        ChildNode node5 = new ChildNode(5, null, null, null);
        ChildNode node6 = new ChildNode(6, null, null, null);
        ChildNode node7 = new ChildNode(7, null, null, null);
        ChildNode node8 = new ChildNode(8, null, null, null);
        ChildNode node9 = new ChildNode(9, null, null, null);
        ChildNode node10 = new ChildNode(10, null, null, null);
        ChildNode node11 = new ChildNode(11, null, null, null);
        ChildNode node12 = new ChildNode(12, null, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node3.child = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        node8.child = node11;
        node11.next = node12;

        return node1;
    }
}
