package com.leetcode.HashTable;

import com.leetcode.Helper.*;

import java.util.*;

public class LC149 {

    public int maxPoints(Point[] points) {
        // horizontal, vertical, x parall, y parall
        if(points.length <= 2) {
            return points.length;
        }
        int count = 0;
        count = Math.max(count, maxPointsHorizontal(points));
        count = Math.max(count, maxPointsVertical(points));
        count = Math.max(count, maxPointsDiagonal(points));
        return count;
    }

    public int maxPointsHorizontal(Point[] points) {
        // horizontal, vertical, x parall, y parall
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            map.clear();
            for(int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if((p1.x == p2.x && p1.y == p2.y) || p1.y == p2.y) {
                    if(!map.containsKey(p1.y)) {
                        map.put(p1.y, 1);
                    } else {
                        int v = map.get(p1.y);
                        map.put(p1.y, ++v);
                    }
                    count = Math.max(count, map.get(p1.y) + 1);
                }
            }
        }
        return count;
    }

    public int maxPointsVertical(Point[] points) {
        // horizontal, vertical, x parall, y parall
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            map.clear();
            for(int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if((p1.x == p2.x && p1.y == p2.y) || p1.x == p2.x) {
                    if(!map.containsKey(p1.x)) {
                        map.put(p1.x, 1);
                    } else {
                        int v = map.get(p1.x);
                        map.put(p1.x, ++v);
                    }
                    count = Math.max(count, map.get(p1.x) + 1);
                }
            }
        }
        return count;
    }

    public int maxPointsDiagonal(Point[] points) {
        // horizontal, vertical, x parall, y parall
        // {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}, {1, 5}, {5, 1}};
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            int same = 1;
            int count = 0;
            map.clear();
            for(int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                int d1 = p1.x - p2.x;
                int d2 = p1.y - p2.y;
                if((d1 == 0 && d2 != 0 ) || (d1 != 0 && d2 == 0)) {
                    continue;
                }
                int gcd = getGCD(d1, d2);
                if(gcd == 0) {
                    same++;
                } else {
                    d1 = d1 / gcd;
                    d2 = d2 / gcd;
                    int key = d1 * d2;
                    if(!map.containsKey(key)) {
                        map.put(key, 1);
                    } else {
                        int v = map.get(key);
                        map.put(key, ++v);
                    }
                    count = Math.max(count, map.get(key));
                }
            }
            max = Math.max(max, count + same);
        }
        return max;
    }

    private int getGCD(int x, int y) {
        /// 24 18
        if(x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if(y == 0) {
            return x;
        }

        while(y != 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x;

    }

    private static class Solution1 {

        public int maxPoints(Point[] points) {
            if(points == null) return 0;
            if(points.length <= 2) return points.length;

            int max = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0; i < points.length; i++) {
                map.clear();
                int same = 1, x0 = 0, y0 = 0, others = 0;
                for(int j = i + 1; j < points.length; j++) {
                    int x = points[i].x - points[j].x;
                    int y = points[i].y - points[j].y;
                    if(x == 0 && y == 0) {
                        same++;
                    } else if (x == 0) {
                        y0++;
                        others = Math.max(others, y0);
                    } else if (y == 0) {
                        x0++;
                        others = Math.max(others, x0);
                    } else {
                        int gcd = gcd(x, y);
                        x = x / gcd;
                        y = y / gcd;
                        int key = x * y;
                        if(map.containsKey(key) == false) {
                            map.put(key, 1);
                        } else {
                            int val = map.get(key);
                            val++;
                            map.put(key, val);
                        }
                        others = Math.max(others, map.get(key));
                    }
                }
                max = Math.max(max, others + same);
            }
            return max;
        }

        private int gcd(int x, int y) {
            if(y == 0) {
                return x;
            }

            while(y != 0) {
                int mod = x % y;
                x = y;
                y = mod;
            }
            return x;
        }
    }


    public static void main(String[] args) {
        // int[][] nums = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}, {1, 5}, {5, 1}};
        int[][] nums = new int[][]{{0,0},{1, 1},{0,0}};
        ArrayList<Point> list = new ArrayList<Point>();
        for(int[] array : nums) {
            Point p = new Point(array[0], array[1]);
            list.add(p);
        }

        Point[] points = list.toArray(new Point[list.size()]);
        LC149 obj = new LC149();
        PrintUtils.printString("res:" + obj.maxPoints(points));

//        Solution1 obj = new Solution1();
//        PrintUtils.printString("res:" + obj.maxPoints(points));
    }
}
