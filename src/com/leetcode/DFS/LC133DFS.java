package com.leetcode.DFS;

import com.leetcode.Helper.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class LC133DFS {

    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Integer, Node>());
    }

    private Node dfs(Node node, HashMap<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, cloneNode);
        for(Node nei : node.neighbors) {
            cloneNode.neighbors.add(dfs(nei, map));
        }
        return cloneNode;
    }

    public static void main(String[] args) {

    }
}
