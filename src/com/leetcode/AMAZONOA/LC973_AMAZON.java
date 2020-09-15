package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**

K Nearest Post Offices
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]]

* */
public class LC973_AMAZON {
    private static class Axis {
        int x;
        int y;
        public Axis(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        int k = K;
        PriorityQueue<Axis> pq = new PriorityQueue<Axis>(k, new Comparator<Axis>(){
            public int compare(Axis a, Axis b) {
                return a.x * a.x + a.y * a.y - (b.x * b.x + b.y * b.y);
            }
        });

        int row = points.length;
        int col = points[0].length;
        for (int[] list : points) {
            pq.offer(new Axis(list[0], list[1]));
        }

        int i = 0;
        List<Axis> list = new ArrayList<Axis>();
        while(!pq.isEmpty()) {
            Axis p = pq.poll();
            i++;
            if (i <= k) {
                list.add(p);
            }
        }
        int size = list.size();
        i = 0;
        int[][] res = new int[size][2];
        for (int[] array : res) {
            array[0] = list.get(i).x;
            array[1] = list.get(i).y;
            i++;
        }
        return res;
    }

}
