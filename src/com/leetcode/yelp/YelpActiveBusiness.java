package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * // <-- EXPAND to see the data classes
 * import java.io.*;
 * import java.util.*;
 *
 * class Event{
 *     String eventType;
 *     int occurrences;
 *     int bizId;
 *
 *     public Event(String eventType, int occurrences, int bizId){
 *         this.eventType = eventType;
 *         this.occurrences = occurrences;
 *         this.bizId = bizId;
 *     }
 *
 *     public String getEventType() { return this.eventType; }
 *     public int getOccurrences() { return this.occurrences; }
 *     public int getBizId() { return this.bizId; }
 * }
 *
 * class Solution {
 *
 *     public List<Integer> findActiveBusinesses(List<Event> events) {
 *         // COMPLETE ME
 *         double photo_views = 0.0;
 *         double ads = 0.0;
 *         double pageViews = 0.0;
 *         double reviews = 0.0;
 *         double photoViewsCount = 0.0;
 *         double adsCount = 0.0;
 *         double pageViewsCount = 0.0;
 *         double reviewsCount = 0.0;
 *
 *        for(Event event : events) {
 *             if (event.eventType.equals("photo_views")) {
 *                 photo_views += event.occurrences;
 *                 photoViewsCount++;
 *             }
 *             if (event.eventType.equals("ads")) {
 *                 ads += event.occurrences;
 *                 adsCount++;
 *             }
 *             if (event.eventType.equals("page_views")) {
 *                 pageViews += event.occurrences;
 *                 pageViewsCount++;
 *             }
 *             if (event.eventType.equals("reviews")) {
 *                 reviews += event.occurrences;
 *                 reviewsCount++;
 *             }
 *         }
 *         double photoViewsAverage = photoViewsCount == 0 ? 0 : (photo_views / photoViewsCount);
 *         double adsAverage = adsCount == 0 ? 0 : (ads / adsCount);
 *         double pageViewsAverage = pageViewsCount == 0 ? 0 : (pageViews / pageViewsCount);
 *         double reviewsAverage = reviewsCount == 0 ? 0 : (reviews / reviewsCount);
 *
 *         Map<Integer, Integer> businessMap = new HashMap<>();
 *
 *         List<Integer> res = new ArrayList<>();
 *         for(Event event : events) {
 *             if (event.eventType.equals("photo_views") && event.occurrences >= photoViewsAverage) {
 *                 process(businessMap, event, res);
 *             } else if (event.eventType.equals("ads") && event.occurrences >= adsAverage) {
 *                 process(businessMap, event, res);
 *             } else if (event.eventType.equals("page_views") && event.occurrences >= pageViewsAverage) {
 *                 process(businessMap, event, res);
 *             } else if (event.eventType.equals("reviews") && event.occurrences >= reviewsAverage) {
 *                 process(businessMap, event, res);
 *             }
 *         }
 *         Collections.sort(res);
 *         return res;
 *     }
 *
 *     private void process(Map<Integer, Integer> map, Event event, List<Integer> res) {
 *         if (map.containsKey(event.bizId)) {
 *             /// guarantee occurrences greater than 1
 *             if (!res.contains(event.bizId)) {
 *                 res.add(event.bizId);
 *             }
 *         } else {
 *             map.put(event.bizId, 1);
 *         }
 *     }
 *
 *     public static void main(String[] args) throws Exception{
 *         String line;
 *         List<Event> events = new ArrayList<Event>();
 *
 *         try{
 *             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *             while ((line = br.readLine()) != null ) {
 *                 String[] parts = line.split(" ");
 *                 if(parts.length<2) break;
 *                 Event e = new Event(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
 *                 events.add(e);
 *             }
 *             Solution solution = new Solution();
 *             List<Integer> activeBusinesses = solution.findActiveBusinesses(events);
 *             for(Integer bizId : activeBusinesses) {
 *                 System.out.println(bizId);
 *             }
 *         } catch(Exception e) {
 *             e.printStackTrace();
 *         }
 *     }
 * }
 *
 **/

/**
 *1. Active Business
 * https://leetcode.com/discuss/interview-question/373625/yelp-oa-2019-active-business
 * 题目说的是输入一些事件，事件的属性包括类型（photo_view, ads, page_views, reviews 四种）, 次数，Bus‍‌‌‌‌‌‍‌‍‌‌iness ID
 *     当一个Business有两种事件的次数等于或超过该事件在所有Business中次数的平均值，那么视这个事件为ActiveBusiness。
 *     要求输出所有ActiveBusiness的Business ID。
 *     相同Business ID的相同事件只会有一个条目记录总次数。
 *
 *     举个例子：
 *                             type,times,B_ID
 *         events.add(new Event("ads", 7, 3)); >= 6.67 (3, 1)
 *         events.add(new Event("ads", 8, 2)); >= 6.67
 *         events.add(new Event("ads", 5, 1));
 *         events.add(new Event("page_views", 11, 2));
 *         events.add(new Event("page_views", 12, 3)); >= 11.5 (3, 2)
 *         events.add(new Event("photo_views", 10, 1));
 *         events.add(new Event("reviews", 7, 2)); >= 7
 *
 *         上面的事件中可以确定2和3是active business，因为ads事件的平均次数是 7 + 8 + 5 / 3 = 6.67，page_views是 11 + 12 / 2 = 11.5，
 *         photo_views是10，reviews是7。
 *         2的ads和reviews满足条件，3的ads和page_views满足条件，但是1只有一个photo_views满足。（有两个或两个以上类型满足就算）
 *
 *     解法：
 *     1. 遍历事件List计算每种事件的平均次数，并使用 Map<Integer, Integer[]> 将每个Business ID和其四种事件次数存入HashMap。
 *     2. 遍历HashMap将满足条件的Business ID存入结果List并返回。
 */

public class YelpActiveBusiness {

    public static int eventTypeAmount;

    private static class Event{
        String type;
        int times;
        int biz_id;

        public Event(String type, int times, int biz_id) {
            this.type = type;
            this.times = times;
            this.biz_id = biz_id;
        }
    }

    public List<Integer> findActiveBusiness(List<Event> events, int eventTypeAmount) {
        double photo_views = 0;
        double ads = 0;
        double page_views = 0;
        double reviews = 0;
        double photo_views_count = 0;
        double ads_count = 0;
        double page_views_count = 0;
        double reviews_count = 0;

        for(Event event : events) {
            if (event.type.equals("photo_views")) {
                photo_views += event.times;
                photo_views_count++;
            }
            if (event.type.equals("ads")) {
                ads += event.times;
                ads_count++;
            }
            if (event.type.equals("page_views")) {
                page_views += event.times;
                page_views_count++;
            }
            if (event.type.equals("reviews")) {
                reviews += event.times;
                reviews_count++;
            }
        }
        double photo_views_average = photo_views_count == 0 ? 0 : (photo_views / photo_views_count);
        double ads_average = ads_count == 0 ? 0 : (ads / ads_count);
        double page_views_average = page_views_count == 0 ? 0 : (page_views / page_views_count);
        double reviews_average = reviews_count == 0 ? 0 : (reviews / reviews_count);
        Map<Integer, Integer> businessMap = new HashMap<>();

        List<Integer> res = new ArrayList<>();
        for(Event event : events) {
            if (event.type.equals("photo_views") && event.times >= photo_views_average) {
                if (businessMap.containsKey(event.biz_id)) {
                    if (!res.contains(event.biz_id)) {
                        res.add(event.biz_id);
                    }
                } else {
                    businessMap.put(event.biz_id, 1);
                }
            } else if (event.type.equals("ads") && event.times >= ads_average) {
                if (businessMap.containsKey(event.biz_id) ) {
                    if (!res.contains(event.biz_id)) {
                        res.add(event.biz_id);
                    }
                } else {
                    businessMap.put(event.biz_id, 1);
                }
            } else if (event.type.equals("page_views") && event.times >= page_views_average) {
                if (businessMap.containsKey(event.biz_id)) {
                    if (!res.contains(event.biz_id)) {
                        res.add(event.biz_id);
                    }
                } else {
                    businessMap.put(event.biz_id, 1);
                }
            } else if (event.type.equals("reviews") && event.times >= reviews_average) {
                if (businessMap.containsKey(event.biz_id)) {
                    if (!res.contains(event.biz_id)) {
                        res.add(event.biz_id);
                    }
                } else {
                    businessMap.put(event.biz_id, 1);
                }
            }
        }
        return res;
    }

    public List<Integer> _findActiveBusiness(List<Event> events, int eventTypeAmount) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer[]> bizs = new HashMap<>();
        int[] sum = new int[eventTypeAmount];
        int[] count = new int[eventTypeAmount];
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).type.equals("photo_views")) {
                sum[0] += events.get(i).times;
                count[0]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[0] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[0] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("ads")) {
                sum[1] += events.get(i).times;
                count[1]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[1] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[1] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("page_views")) {
                sum[2] += events.get(i).times;
                count[2]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[2] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[2] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            } else if (events.get(i).type.equals("reviews")) {
                sum[3] += events.get(i).times;
                count[3]++;
                if (!bizs.containsKey(events.get(i).biz_id)) {
                    Integer[] temp = {0, 0, 0, 0};
                    temp[3] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                } else {
                    Integer[] temp = bizs.get(events.get(i).biz_id);
                    temp[3] = events.get(i).times;
                    bizs.put(events.get(i).biz_id, temp);
                }
            }
        }
        double[] avg = new double[4];
        for (int i = 0; i < sum.length; i++) {
            if (count[i] != 0)
                avg[i] = sum[i] / count[i];
        }
        for (int i: bizs.keySet()) {
            Integer[] t = bizs.get(i);
            int c = 0;
            for (int j = 0; j < t.length; j++) {
                if (t[j] >= avg[j])
                    c++;
            }
            if (c >= 2)
                res.add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        eventTypeAmount = 4;
        events.add(new Event("ads", 7, 3));
        events.add(new Event("ads", 8, 2));
        events.add(new Event("ads", 5, 1));
        events.add(new Event("page_views", 11, 2));
        events.add(new Event("page_views", 12, 3));
        events.add(new Event("photo_views", 10, 3));
        events.add(new Event("reviews", 7, 2));

        YelpActiveBusiness obj = new YelpActiveBusiness();
        List<Integer> res = obj.findActiveBusiness(events, eventTypeAmount);
        PrintUtils.printListInteger(res);
    }
}
