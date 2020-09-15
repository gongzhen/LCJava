package com.leetcode.Graph;

import com.leetcode.Helper.Node;

import java.util.*;

public class LC133 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>(); /// original.val, newNode
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, cloneNode);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node _node = queue.poll(); // original node
            // Node _cloneNode = map.get(_node.val);
            for(Node _neighbor : _node.neighbors) {
                if (!map.containsKey(_neighbor.val)) {
                    queue.offer(_neighbor);
                    Node _cloneNeighbor = new Node(_neighbor.val, new ArrayList<Node>());
                    map.put(_neighbor.val, _cloneNeighbor);
                }
                map.get(_node.val).neighbors.add(map.get(_neighbor.val));
            }
        }
        return map.get(node.val);
    }

    public static void main(String[] args) {
    }
}
