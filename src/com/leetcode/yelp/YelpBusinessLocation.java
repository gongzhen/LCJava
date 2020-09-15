package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/**
 * 2. Business Location
 * 题目的意思是输入一堆stores，里面存了商店名称，城市，ID。一个城市可能有多个不同ID但是相同名字的‍‌‌‌‌‌‍‌‍‌‌store。
 *     输出一个List，里面是某个城市拥有的所有store名称和对应的数量，按照数量从少到多排列（这里存疑，不知道是从少到多还是从多到少），如果数量相同则按照字母顺序排列。
 *
 *     像这样：
 *                              StoreName     City    ID
 *         stores.add(new Store("Walmart", "San Jose", 1));
 *         stores.add(new Store("Walmart", "Los Angeles", 2));
 *         stores.add(new Store("Bestbuy", "San Jose", 3));
 *         stores.add(new Store("Bestbuy", "Los Angeles", 4));
 *         stores.add(new Store("Bestbuy", "Dallas", 5));
 *         stores.add(new Store("Bed&Bath", "San Jose", 6));
 *         stores.add(new Store("Bestbuy", "San Jose", 7));
 *         stores.add(new Store("Bestbuy", "San Jose", 8));
 *         stores.add(new Store("Walmart", "San Jose", 9));
 *         stores.add(new Store("Walgreen", "San Jose", 10));
 *         stores.add(new Store("Walgreen", "San Jose", 11));
 *
 *     如果需要查询San Jose则返回：Map<String = cityName, Map<String = storeName, Integer = storeNumber>>
 *         Bed&Bath:1
 *         Walgreen:2
 *         Walmart:2
 *         Bestbuy:3
 *
 *     解法：
 *     1. 遍历stores将要查询的城市的所有商店名称和对应的数量用HashMap存下来。
 *     2. 使用List<Map.Entry<String,Integer>>将HashMap排序保存并返回（需要自己写Comparator）。
 *
 */

public class YelpBusinessLocation {

    private static class Store {
        String name;
        String city;
        int businessID;

        public Store(String n, String c, int b) {
            name = n;
            city = c;
            businessID = b;
        }
    }

    public List<Map.Entry<String,Integer>> findStores(List<Store> stores, String city) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).city.equals(city)) {
                if (map.containsKey(stores.get(i).name)) {
                    Integer temp = map.get(stores.get(i).name);
                    map.put(stores.get(i).name, temp + 1);
                } else {
                    map.put(stores.get(i).name, 1);
                }
            }
        }

        List<Map.Entry<String,Integer>> res = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return o1.getValue().compareTo(o2.getValue());
                } else if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        return res;
    }

    public static void main(String[] args) {
        YelpBusinessLocation obj = new YelpBusinessLocation();
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("Walmart", "San Jose", 1));
        stores.add(new Store("Walmart", "Los Angeles", 2));
        stores.add(new Store("Bestbuy", "San Jose", 3));
        stores.add(new Store("Bestbuy", "Los Angeles", 4));
        stores.add(new Store("Bestbuy", "Dallas", 5));
        stores.add(new Store("Bed&Bath", "San Jose", 6));
        stores.add(new Store("Bestbuy", "San Jose", 7));
        stores.add(new Store("Bestbuy", "San Jose", 8));
        stores.add(new Store("Walmart", "San Jose", 9));
        stores.add(new Store("Walgreen", "San Jose", 10));
        stores.add(new Store("Walgreen", "San Jose", 11));
        List<Map.Entry<String,Integer>> res = obj.findStores(stores,"San Jose");
        PrintUtils.printListOfMapEntry(res);
    }
}
