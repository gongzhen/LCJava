package com.leetcode.Array;

import com.leetcode.Helper.Interval;
import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default
 * code definition to get new method signature.
 */

public class LC252 {

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length == 0) {
            return false;
        }

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start == o2.start) {
                    return 0;
                }
                return -1;
            }
        });

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC252 obj = new LC252();
        // [[0,30],[5,10],[15,20]]
        boolean res = obj.canAttendMeetings(new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)});
        PrintUtils.printBool(res);
        // [[7,10],[2,4]]
        res = obj.canAttendMeetings(new Interval[]{new Interval(7, 10), new Interval(2, 4)});
        PrintUtils.printBool(res);
    }
}
