package com.leetcode.Graph;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC261 {

    private static class Solution1 {

        public boolean validTree(int n, int[][] edges) {
            if (n <= 0 || edges == null)
                return false;
            if (edges.length != n - 1)
                return false;
            int[] fathers = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
            for (int[] edge : edges) {
                int fax = find(fathers, edge[0]);
                int fay = find(fathers, edge[1]);
                if (fax == fay)
                    return false;
                fathers[fax] = fay;
            }
            return true;
        }

        private int find(int[] fathers, int x) {
            int fa = fathers[x];
            while (fa != fathers[fa]) {
                fa = fathers[fa];
            }
            return fa;
        }
    }


    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     *
     * For example:
     *
     * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
     *
     * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
     *
     * Hint:
     *
     * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
     * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two
     * vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
     * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
     * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     *
     */


    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if(visited[node] == true) {
                return false;
            }
            visited[node] = true;
            List<Integer> list = graph.get(node);
            for(Integer e : list) {
                queue.offer(e);
                graph.get(e).remove(node);
            }
        }

        for(boolean r : visited) {
            if(!r) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges1 = new int[][] {
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };
        LC261 obj = new LC261();
        PrintUtils.printString("result: "  +obj.validTree(5, edges1));
        int[][] edges2 = new int[][] {
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };
        PrintUtils.printString("result: "  +obj.validTree(5, edges2));
    }
}
