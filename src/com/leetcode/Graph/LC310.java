package com.leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        根据边统计每个节点的入度数记入in[i]
//        找出度数为1的节点加入到Queue
//        取出队首节点，把此节点邻接的节点度数减1，如果度数为0，加入到队列，循环直到队列为空
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length; i++) {
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            graph.get(edges[i][1]).add(edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        

        return res;
    }

    public static void main(String[] args) {

    }
}
