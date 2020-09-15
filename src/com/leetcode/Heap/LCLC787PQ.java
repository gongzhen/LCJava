package com.leetcode.Heap;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LCLC787PQ {

    private static class DestCostCount{
        int dst;
        int cost;
        int count;
        public DestCostCount(int dst, int cost, int count) {
            this.dst = dst;
            this.cost = cost;
            this.count = count;
        }
    }

    private static class DestCost{
        int dst;
        int cost;
        public DestCost(int src, int cost) {
            this.dst = src;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<DestCost>> map = new HashMap<>();
        for(int[] flight : flights) {
            if(!map.containsKey(flight[0])) {
                map.put(flight[0], new ArrayList<>());
            }
            map.get(flight[0]).add(new DestCost(flight[1], flight[2]));
        }

        PriorityQueue<DestCostCount> pq = new PriorityQueue<DestCostCount>(new Comparator<DestCostCount>(){
            public int compare(DestCostCount c1, DestCostCount c2) {
                if (c1.cost == c2.cost) {
                    return 0;
                } else if (c1.cost < c2.cost) {
                    return -1;
                }
                return 1;
            }
        });

        pq.offer(new DestCostCount(src, 0, K+1));
        while(!pq.isEmpty()) {
            DestCostCount dct = pq.poll();
            if(dct.dst == dst) {
                return dct.cost;
            }
            if (dct.count > 0) {
                List<DestCost> list = map.getOrDefault(dct.dst, new ArrayList<>());
                for (DestCost flight : list) {
                    pq.offer(new DestCostCount(flight.dst, flight.cost + dct.cost, dct.count - 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}
        };
        // int[][] flights = new int[][]{{3,4,2},{4,2,10},{0,3,3}};
        LCLC787PQ obj = new LCLC787PQ();
        int res = obj.findCheapestPrice(5, flights, 0, 4, 1);
        PrintUtils.printString("re: " + res);
    }
}
