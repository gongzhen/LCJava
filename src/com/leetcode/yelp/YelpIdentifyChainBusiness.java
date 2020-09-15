package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 * https://www.1point3acres.com/bbs/thread-548990-1-1.html
 *
 */
public class YelpIdentifyChainBusiness {

    private static class Business {
        String name;
        String location;
        String id;
        public Business(String name, String location, String id) {
            this.name = name;
            this.location = location;
            this.id = id;
        }
    }

    private static class Chain {
        String name;
        Integer frequency;
        public Chain(String name, Integer frequency) {
            this.name = name;
            this.frequency = frequency;
        }
    }

    private boolean isSameBusiness(Business b1, Business b2) {
        if (b1.name.equals(b2.name) && b1.location.equals(b2.location) && b1.id.equals(b2.id)) {
            return true;
        }
        return false;
    }

    public List<Chain> detectAndOrderChainBusiness(List<Business> business, String location) {

        List<Business> uniqueBusiness = new ArrayList<>();
        for(Business bus : business) {
            if (uniqueBusiness.size() == 0) {
                uniqueBusiness.add(bus);
            } else {
                int i = 0;
                while(i < uniqueBusiness.size()) {
                    Business bb = uniqueBusiness.get(i);
                    if (isSameBusiness(bus, bb)) {
                        break;
                    }
                    i++;
                }
                if (i == uniqueBusiness.size()) {
                    uniqueBusiness.add(bus);
                }
            }
        }

        Map<String, List<Chain>> map = new HashMap<>();
        for (Business bus : uniqueBusiness) {
            String location1 = bus.location;
            if (!map.containsKey(location1)) {
                map.put(location1, new ArrayList<Chain>());
                Chain chain = new Chain(bus.name, 1);
                map.get(location1).add(chain);
            } else {
                List<Chain> chainList = map.get(location1);
                int i = 0;
                while ( i < chainList.size()) {
                    Chain chain = chainList.get(i);
                    if (chain.name.equals(bus.name)) {
                        int frequency = chain.frequency;
                        chain.frequency = frequency + 1;
                        break;
                    }
                    i++;
                }
                if (i == chainList.size()) {
                    chainList.add(new Chain(bus.name, 1));
                }
            }
        }

        return map.get(location);
    }

    public static void main(String[] args) {
        List<Business> business = new ArrayList<>();
        business.add(new Business("Starbucks", "Seattle", "101"));
        business.add(new Business("PeetsCoffe", "San Francisco", "102"));
        business.add(new Business("Whole Foods", "Austin", "103"));
        business.add(new Business("Starbucks", "San Francisco", "104"));
        business.add(new Business("PeetsCoffe", "Austin", "105"));
        business.add(new Business("Starbucks", "Austin", "106"));
        business.add(new Business("Whole Foods", "Austin", "103"));
        business.add(new Business("Whole Foods", "Austin", "107"));
        YelpIdentifyChainBusiness obj = new YelpIdentifyChainBusiness();
        List<Chain> res = obj.detectAndOrderChainBusiness(business, "Austin");
        for(Chain c : res) {
            PrintUtils.printString("" + c.name + " - " + c.frequency);
        }
    }
}
