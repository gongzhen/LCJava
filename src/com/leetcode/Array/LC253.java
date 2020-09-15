package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * */
public class LC253 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // [[0, 30],[5, 10],[15, 20]]
        int count = 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for(int i = 0; i < len; i++) {
            starts[i] = intervals[i][0];
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        for(int i = 0; i < len; i++) {
            ends[i] = intervals[i][1];
        }

        int i = 0;
        int j = 0;
        // 0, 5, 15
        // 10, 20, 30
        while(i < starts.length && j < ends.length) {
            if (starts[i] < ends[j]) {
                count++;
                i++;
            } else {
                // count--;
                j++;
                // count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC253 obj = new LC253();
        int res = obj.minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}});
        PrintUtils.printString("res:" + res);
        res = obj.minMeetingRooms(new int[][]{{1, 10},{2, 7},{3, 19},{8, 12},{10, 20},{11, 30}});
        PrintUtils.printString("res:" + res);
    }
}
