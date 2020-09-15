package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC1057 {

    private static class Coordiate {
        // worker index, biker index
        int w;
        int b;
        public Coordiate(int w, int b) {
            this.w = w;
            this.b = b;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workLen = workers.length;
        int bikersLen = bikes.length;
        Map<Integer, List<Coordiate>> map = new HashMap<>();
        for(int i = 0; i < workLen; i++) {
            for(int j = 0; j < bikersLen; j++) {
                int manDist = manDistance(bikes[j], workers[i]);
                if (!map.containsKey(manDist)) {
                    map.put(manDist, new ArrayList<Coordiate>());
                }
                map.get(manDist).add(new Coordiate(i, j));
            }
        }
        List<Integer> sortDist = new ArrayList<>(map.keySet());
        Collections.sort(sortDist);

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] bikesVisited = new boolean[bikes.length];
        for(int dist : sortDist) {
            if (map.containsKey(dist)) {
                List<Coordiate> list = map.get(dist);
                for(Coordiate coordiate : list) {
                    int bikeIdx = coordiate.b;
                    int workerIdx = coordiate.w;
                    if (bikesVisited[bikeIdx] == true || res[workerIdx] != -1) {
                        continue;
                    }
                    bikesVisited[bikeIdx] = true;
                    res[workerIdx] = bikeIdx;
                }
            }
        }
        return res;
    }

    private int manDistance(int[] bike, int[] worker) {
        return Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
    }

    public static void main(String[] args) {
        LC1057 obj = new LC1057();
        int[] res = obj.assignBikes(new int[][]{{0,0},{2,1}}, new int[][]{{1,2}, {3,3}}); // [1, 0]
        PrintUtils.printArray(res);
    }

}
