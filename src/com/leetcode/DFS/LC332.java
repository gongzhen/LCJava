package com.leetcode.DFS;

import com.leetcode.HashTable.LC3;
import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            if(!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<String>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
            map.get(ticket.get(0)).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });
        }
        PrintUtils.printMapKeyStringValueList(map);
        List<String> res = new ArrayList<>();
        dfs(map, res, "JFK");
        return res;
    }

    private void dfs(Map<String, List<String >> map, List<String> list, String city) {
        List<String> queue = map.get(city);
        while(queue!= null && queue.isEmpty() == false) {
            String name = queue.remove(queue.size() - 1);
            dfs(map, list, name);
        }
        list.add(0, city);
    }

    public static void main(String[] args) {
        LC332 obj = new LC332();
        List<List<String>> tickets = new ArrayList<>();
        String[][] cityArray = new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        for(String[] cities : cityArray) {
            tickets.add(new ArrayList<>(Arrays.asList(cities)));
        }
        List<String> res = obj.findItinerary(tickets);
        PrintUtils.printListString(res);

        cityArray = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        tickets.clear();
        for(String[] cities : cityArray) {
            tickets.add(new ArrayList<>(Arrays.asList(cities)));
        }
        res = obj.findItinerary(tickets);
        PrintUtils.printListString(res);
    }
}
