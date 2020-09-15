package com.leetcode.BFS;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC787 {

    private static class DestCost{
        int dst;
        int cost;
        public DestCost(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    private static class Flight{
        int src;
        int cost;
        public Flight(int src, int cost) {
            this.src = src;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build Graph
        Map<Integer, List<DestCost>> map = new HashMap<>();
        for(int i = 0; i < flights.length; i++) {
            if (map.containsKey(flights[i][0]) == false) { // 0: src
                map.put(flights[i][0], new ArrayList<DestCost>());
            }
            map.get(flights[i][0]).add(new DestCost(flights[i][1], flights[i][2])); // src -> {dst, cost}
        }

        // 0, [1, 100][2, 500]
        // src, dst, int k = 0 < K
        // map.get src to find list.
        // if k == K && dest == dst: then return cost.
        Queue<Flight> queue = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        queue.offer(new Flight(src, 0)); // dest -> cost
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Flight flight = queue.poll();
                int city = flight.src;
                int cost = flight.cost;
                if (city == dst) {
                    ans = Math.min(ans, cost);
                }
                if(map.containsKey(city) == true) {
                    for (DestCost d : map.get(city)) {
                        if (cost + d.cost > ans) {
                            continue;
                        }
                        queue.offer(new Flight(d.dst, cost + d.cost));
                    }
                }
            }
            if (step++ > K) {
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        // int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
//        5
//                [[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]]
//        0
//        4
//        1
        int[][] flights = new int[][]{
                {1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}
        };
        // int[][] flights = new int[][]{{3,4,2},{4,2,10},{0,3,3}};
        LC787 obj = new LC787();
        int res = obj.findCheapestPrice(5, flights, 0, 4, 1);
        PrintUtils.printString("re: " + res);
    }
}
