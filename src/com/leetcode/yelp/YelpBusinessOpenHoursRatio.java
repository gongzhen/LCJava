package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/discuss/interview-question/304617/Yelp-or-OA-2019-or-Business-Open-Hours-Ratio
 * */
public class YelpBusinessOpenHoursRatio {

    private static class TimeRange {
        public int start;
        public int end;
        public TimeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public float openHoursRatio(TimeRange query, List<TimeRange> openHours){
        if(openHours == null || openHours.size() == 0){
            return 0.0f;
        }

        /**
         * query,   open
         * 4-10    0-24       0 < 4 && 10 < 24 6 / 6 = 1
         * 7-17    9-11   17-7 = 10   11-9 = 2 2/10 = 0.25
         * 7-11    9-17   11-7 = 4   11-9 = 2 2/4 = 0.5
         * 0-24    0-2, 20-24,   (2 + 4) / 24 = 0.25
         */
        float rate = 0.0f;
        int queryTime = query.end - query.start;
        int sum = 0;
        for(TimeRange open : openHours){
            if(open.start <= query.start && open.end >= query.end){ //the query time include in open hours
                sum += query.end - query.start;;
            } else if(open.start > query.start && open.end < query.end){ //the open hours include in query time
                sum += open.end-open.start;
            } else {
                if(open.start <= query.start && open.end <= query.end && open.end >= query.start){
                    sum += open.end - query.start;
                }
                if(query.start <= open.start && query.end <= open.end && query.end >= open.start){
                    sum += query.end - open.start;
                }
            }
        }
        rate = Float.intBitsToFloat(sum)/Float.intBitsToFloat(queryTime);
        return rate;
    }

    public static void main(String[] args) {
        YelpBusinessOpenHoursRatio obj = new YelpBusinessOpenHoursRatio();
        List<TimeRange> list = new ArrayList<>();
        list.add(new TimeRange(0, 24));
        list.add(new TimeRange(9, 17));
        list.add(new TimeRange(0, 2));
        float res = obj.openHoursRatio(new TimeRange(7, 11), list);
        PrintUtils.printString("res: " + res);
    }
}
