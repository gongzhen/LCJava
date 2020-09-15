package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 *   4. Reacha‍‌‌‌‌‌‍‌‍‌‌ble Business
 *   Yelp can recommend businesses based on a distance you're willing to travel.
 *
 * Given a distance input and a connected acyclic graph of businesses with edges as distances, return the list of names of businesses within the distance input.
 *
 * Args:
 *
 * starting business: a Business object to start from
 * distance: int
 * Output:
 *
 * list of str: A list of Business names that are within the given distance of the starting Business
 * Distance is inclusive, meaning if a business is 5 away, then a distance input of 5 means that business IS reachable.
 *
 * The return value should NOT have the name of the starting business. Therefore, if no businesses are within the given distance, return an empty list.
 *
 * The return value is NOT required to be sorted.
 *
 * Example:
 *
 * Consider the following graph with distances where business A is the starting business.
 *
 *            A
 *          /  \
 *       2 /    \ 4
 *        /      \
 *       B        C
 *        \
 *         \ 5
 *          \
 *           D
 *
 * findReachableBusinesses(A, 1); // should return an empty list
 * findReachableBusinesses(A, 2); // should return ["B"]
 * findReachableBusinesses(A, 3); // should also return ["B"]
 * findReachableBusinesses(A, 4); // should return ["B", "C"]
 * findReachableBusinesses(A, 7); // should return ["B", "C", "D"]
 *
 *   就是给你一个加权无向图，输出从一个点出发在一定距离之内能到达的所有点。
 *
 *     解法：
 *     1. 使用BFS算法，从起点出发，使用HashMap存储到达每个点需要的距离。
 *     2. 如果HashMap里已经有了对应点的entry则比较新的距离是否小于原来Map中存储的，保持Map为最小距离。
 **/
public class YelpReachableBusiness {

    private static class Business {
        public String name;
        public HashMap<Business, Integer> nearbyBusinesses;

        public Business(String name, HashMap<Business, Integer> nearby_business) {
            this.name = name;
            this.nearbyBusinesses = nearby_business;
        }
    }

    public List<String> findReachableBusinesses(Business startingBusiness, int distance) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Business> queue = new LinkedList<>();
        map.put(startingBusiness.name, 0);
        queue.offer(startingBusiness);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Business node = queue.poll();
            for(Business nearbyBus : node.nearbyBusinesses.keySet()) {
                int nearbyDistance = node.nearbyBusinesses.get(nearbyBus);
                if (!map.containsKey(nearbyBus.name)) {
                    queue.offer(nearbyBus);
                    map.put(nearbyBus.name, nearbyDistance);
                } else {
                    int oldDistance = map.get(nearbyBus.name);
                    if (nearbyDistance < oldDistance) {
                        map.put(nearbyBus.name, nearbyDistance);
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            if (name.equals(startingBusiness.name) == false && map.get(name) <= distance) {
                res.add(name);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Business a = new Business("A", new HashMap<Business, Integer>());
        Business b = new Business("B", new HashMap<Business, Integer>());
        Business c = new Business("C", new HashMap<Business, Integer>());
        Business d = new Business("D", new HashMap<Business, Integer>());
//        Business e = new Business("E", new HashMap<Business, Integer>());
//        Business f = new Business("F", new HashMap<Business, Integer>());
//        Business g = new Business("G", new HashMap<Business, Integer>());
//        Business h = new Business("H", new HashMap<Business, Integer>());
        /**
         *
         *            A
         *          /  \
         *       2 /    \ 4
         *        /      \
         *       B        C
         *        \
         *         \ 5
         *          \
         *           D
         *
         * findReachableBusinesses(A, 1); // should return an empty list
         * findReachableBusinesses(A, 2); // should return ["B"]
         * findReachableBusinesses(A, 3); // should also return ["B"]
         * findReachableBusinesses(A, 4); // should return ["B", "C"]
         * findReachableBusinesses(A, 7); // should return ["B", "C", "D"]
         */
        a.nearbyBusinesses.put(b, 2);
        a.nearbyBusinesses.put(c, 4);
//        a.nearbyBusinesses.put(d, 1);
        b.nearbyBusinesses.put(a, 2);
        b.nearbyBusinesses.put(d, 5);
        c.nearbyBusinesses.put(a, 4);
//        d.nearbyBusinesses.put(a, 1);

        YelpReachableBusiness obj = new YelpReachableBusiness();
        List<String> res = obj.findReachableBusinesses(a, 1);
//        PrintUtils.printListString(res);
        res = obj.findReachableBusinesses(a, 2);
        PrintUtils.printListString(res);
        res = obj.findReachableBusinesses(a, 3);
        PrintUtils.printListString(res);
        res = obj.findReachableBusinesses(a, 4);
        PrintUtils.printListString(res);
        res = obj.findReachableBusinesses(a, 7);
        PrintUtils.printListString(res);
    }
}
