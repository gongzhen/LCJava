package com.leetcode.Design;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int value;
    LRUNode next;
    LRUNode prev;
    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private LRUNode head;
    private LRUNode tail;
    private int capacity;
    private Map<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new LRUNode(-1, -1);
        this.tail = new LRUNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            LRUNode node = map.get(key);
            // move the node to the tail.
            disconnect(node);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }

    private void disconnect(LRUNode node) {
        if (node == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(LRUNode node) {
        if(node == null) {
            return;
        }

        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            LRUNode node = map.get(key);
            node.value = value;
            map.put(key, node);
            return;
        }

        LRUNode newNode = new LRUNode(key, value);
        if(this.capacity == map.size()) {
            map.remove(this.head.next.key);
            disconnect(this.head.next);
        }
        map.put(key, newNode);
        moveToTail(newNode);
    }
}

public class LC146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
