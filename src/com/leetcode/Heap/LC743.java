package com.leetcode.Heap;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC743 {

    private static class Node {
        int u;
        int v;
        int w;
        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static class Pair {
        int dist;
        int target;
        public Pair(int dist, int target) {
            this.dist = dist;
            this.target = target;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int [] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<Node>());
            }
            map.get(u).add(new Node(u, v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                if (a.dist == b.dist) {
                    return 0;
                } else if (a.dist > b.dist) {
                    return 1;
                }
                return -1;
            }
        });
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        pq.offer(new Pair(0, K));
        int dist = 0;
        while(!pq.isEmpty()) {
            Pair distSource = pq.poll();
            if (visited[distSource.target] == true) {
                continue;
            }
            visited[distSource.target] = true;
            dist = distSource.dist;
            // if (visited[distSource.target] == true) {
            //     continue;
            // }
            N--;
            if(map.containsKey(distSource.target)) {
                List<Node> list = map.get(distSource.target);
                for(int i = 0; i < list.size(); i++) {
                    Node node = list.get(i);
                    pq.offer(new Pair(dist + node.w, node.v));
                }
            }
        }
        return N != 0 ? -1 : dist;
    }

    public static void main(String[] args) {
        LC743 obj = new LC743();
        // [[2,1,1],[2,3,1],[3,4,1]]
        // int res = obj.networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2);
        int res = obj.networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,4}}, 3, 1);
        /* *
        *
        * 1 -> 2 (1) 2 -> 3 (2) // 3
        * 1 -> 3 (4)
        *
        *
        *
        *
        *  */
        PrintUtils.printString("res:" + res);
    }
}
