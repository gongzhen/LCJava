package com.leetcode.HashTable;


import java.util.HashMap;
import java.util.Map;

public class LC202 {

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = n;
        while(sum != 1) {
            sum = sum(sum);
            if(map.containsKey(sum)){
                break;
            }
            map.put(sum, 1);
        }
        return sum == 1;
    }
    private int sum(int n) {
        int sum = 0;
        while(n > 0) {
            int model = n % 10;
            sum += Math.pow(model, 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
