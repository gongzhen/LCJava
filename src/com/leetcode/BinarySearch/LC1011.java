package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

public class LC1011 {

    public int shipWithinDays(int[] weights, int D) {
        if(weights.length == 0) {
            return 0;
        }
        int max = findMaxWeight(weights);
        int sum = getSum(weights);

        while(max < sum) {
            int mid = (max + sum) >> 1; // max: max weight, sum total weight.
            int requiredDays = getRequiredDays(weights, mid);
            if (requiredDays == D) {
                PrintUtils.printString("mid" + mid);
            }
            if(requiredDays > D) {
                // raise the max by 1 + mid
                max = mid + 1;
            } else {
                sum = mid;
            }
        }

        return max;
//        return 0;
    }

    private int getRequiredDays(int[] weights, int max) {
        int requiredDays = 1;
        int current = 0;
        for(int weight : weights) {
            current += weight;
            if (current > max) {
                requiredDays++;
                current = weight; // [1, 2, 3,] max = 2 -> [1, 2] [3]
            }
        }
        return requiredDays;
    }

    private int findMaxWeight(int[] weights) {
        int max = 0;
        for(int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for(int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC1011 obj = new LC1011();
//        int days1 = obj.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
//        PrintUtils.printString("res:" + days1);
        int days2 = obj.shipWithinDays(new int[]{3,2,2,4,1,4}, 3);
        PrintUtils.printString("res:" + days2);
    }
}
