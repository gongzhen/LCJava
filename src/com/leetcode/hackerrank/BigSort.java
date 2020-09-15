package com.leetcode.hackerrank;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

public class BigSort {

    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>(){
            public int compare(String u1, String u2){
                if (u1.length() > u2.length()) {
                    return 1;
                } else if (u1.length() == u2.length()) {
                    return u1.compareTo(u2);
                }
                return -1;
            }
        });
        return unsorted;
    }

    public static void main(String[] args) {
        String[] res = BigSort.bigSorting(new String[]{
                "8",
                "44",
                "82",
                "966",
                "88151",
                "96648",
                "63593696",
                "86212388",
                "91478800",
                "139324591",
                "3300953792",
                "4763506513",
                "24851084103",
                "84617645710",
                "5039608483812"
        });
        PrintUtils.printStringArray(res);
    }
}
