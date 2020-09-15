package com.leetcode.Helper;

public class ChildNode {
    public int val;
    public ChildNode prev;
    public ChildNode next;
    public ChildNode child;

    public ChildNode() {}

    public ChildNode(int _val,ChildNode _prev,ChildNode _next,ChildNode _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
