package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CLOSESTKDESTINATIONS {

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
        if(numDestinations < numDeliveries) {
            return new ArrayList<>();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(numDestinations, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int d1 = o1.x * o1.x + o1.y * o1.y;
                int d2 = o2.x * o2.x + o2.y * o2.y;
                if (d1 == d2) {
                    return 0;
                } else if (d1 > d2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for(List<Integer> subList: allLocations) {
            pq.offer(new Pair(subList.get(0), subList.get(1)));
        }

        int i = 0;
        List<List<Integer>> result = new ArrayList<>();

        while(i < numDeliveries && !pq.isEmpty()) {
            Pair p = pq.poll();
            List<Integer> xy = new ArrayList<>();
            xy.add(p.x);
            xy.add(p.y);
            result.add(xy);
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        CLOSESTKDESTINATIONS obj = new CLOSESTKDESTINATIONS();
        int[][] lots = new int[][]{{1, 2}, {3, 4}, {1, -1}};
        List<List<Integer>> lotsList = new ArrayList<>();
        for(int[] array : lots) {
            List<Integer> sublist = new ArrayList<>();
            for(int n : array) {
                sublist.add(n);
            }
            lotsList.add(sublist);
        }

        List<List<Integer>> res = obj.ClosestXdestinations(3, lotsList, 2);
        PrintUtils.printListOfListInteger(res);
    }
}
