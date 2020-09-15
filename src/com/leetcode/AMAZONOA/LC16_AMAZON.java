package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**

 You are on a flight and wanna watch two movies during this flight.
 You are given int[] movie_duration which includes all the movie durations.
 You are also given the duration of the flight which is d in minutes.
 Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

 e.g.
 Input
 movie_duration: [90, 85, 75, 60, 120, 150, 125]
 d: 250

 Output from aonecode.com
 [90, 125]
 90min + 125min = 215 is the maximum number within 220 (250min - 30min)

 * */

public class LC16_AMAZON {

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] twoSumClosest(int[] movie_duration, int d) {
        int target = d - 30;
        if (target < 0) {
            return new int[]{};
        }
        List<Pair> list = new ArrayList<Pair>();
        Arrays.sort(movie_duration);
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = movie_duration.length - 1;
        while (i < j) {
            int sum = movie_duration[i] + movie_duration[j];
            if (sum > target) {
                j--;
            } else {
                if (diff > (target - sum)) {
                    diff = target - sum;
                    list.clear();
                    list.add(new Pair(movie_duration[i], movie_duration[j]));
                } else if (diff == target - sum) {
                    if (list.isEmpty() == false) {
                        if ((movie_duration[i] > list.get(0).x && movie_duration[i] > list.get(0).y)
                                || (movie_duration[j] > list.get(0).x && movie_duration[j] > list.get(0).y)) {
                            list.clear();
                            list.add(new Pair(movie_duration[i], movie_duration[j]));
                        }
                    } else {
                        list.add(new Pair(movie_duration[i], movie_duration[j]));
                    }
                }
                i++;
            }
        }
        if (list.size() == 1) {
            return new int[]{list.get(0).x, list.get(0).y};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LC16_AMAZON obj = new LC16_AMAZON();
        int[] array = new int[]{90, 85, 75, 60, 120, 150, 125};
//        int[] array = new int[]{50, 50, 1, 99};
        int[] result = obj.twoSumClosest(array, 131);
        PrintUtils.printArray(result);
    }

}
