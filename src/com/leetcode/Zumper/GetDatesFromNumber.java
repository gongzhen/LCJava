package com.leetcode.Zumper;

import com.leetcode.Helper.PrintUtils;

public class GetDatesFromNumber {

    private String[] dates = new String[]{"Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"};

    public String getDatesFromNumber(int number) {
        if (number <= 0) {
            return null;
        }

        // 0 -> Mon
        // 6 -> Sun
        // 7 % 7 = 0 -> Mon
        // 8 % 7 = 1 -> Tue
        // 28 % 7 = 0 -> Mon
        // 30 % 7 = 2 -> Wed
        return "";
    }

    public int getLeadingBitOfNumber(int number) {
        if (number < 0) {
            return 0;
        }

        int limit = 1000000000;
        int result = 0;
        while (limit > 0) {
            int carry = number / limit;
            if (carry != 0) {
                result = carry * limit;
                break;
            }
            limit = limit / 10;

        }
        return result;
        // 123 ->  123 / Integer.MAX_VALUE
        // 123 / 100 -> 1 * 100
        // 123 -> 100
        // 1234 -> 1000
        // 12 -> 10
        // 2 -> 2
        // 3 -> 3
        // 1 -> 1

    }

    public static void main(String[] args) {
        GetDatesFromNumber obj = new GetDatesFromNumber();
        int res = obj.getLeadingBitOfNumber(123123);
        PrintUtils.printString("res:" + res);
    }
}
