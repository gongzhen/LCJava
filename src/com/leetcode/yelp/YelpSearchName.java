package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class YelpSearchName {

    private Map<String, List<String>> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public void init(String[] names) {
        for(String name : names) {
            String[] nameArray = name.split(" ");
            for (String word : nameArray) {
                String lowerCase = word.toLowerCase();
                list.add(lowerCase);
                if(!map.containsKey(lowerCase)) {
                    map.put(lowerCase, new ArrayList<>());
                }
                map.get(lowerCase).add(name);
            }
        }
    }

    public void search(String word) {
        Set<String> set = new HashSet<>();
        for(String name : list) {
            if (name.contains(word)) {
                List<String> list = this.map.get(name);
                set.addAll(list);
            }
        }
        List<String> list = new ArrayList<>(set);
        PrintUtils.printListString(list);
    }



    public static void main(String[] args) {
        String[] names = new String[]{
                "Burger King",
                "McDonald's",
                "Bob's Burgers",
                "Five Guys",
                "Wahlburgers",
                "Super Duper Burgers"
        };
        YelpSearchName obj = new YelpSearchName();
        obj.init(names);
        obj.search("bur");
    }
}
