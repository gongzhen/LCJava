package com.leetcode.BinarySearch;

import com.leetcode.Helper.PrintUtils;

import java.util.Random;

public class LC528 {

    private int[] weight;
    private Random rand = new Random();

    public LC528(int[] w) {
        // 1, 2, 3, 4,5
        // 1 / sum .... 5 / sum
        this.weight = new int[w.length];
        int i = 0;
        int sum = 0;
        for(int n : w) {
            sum += n;
            this.weight[i++] = sum;
        }
    }

    public int pickIndex() {
        int len = this.weight.length;
        if (len == 0) {
            return -1;
        }
        int randNum = rand.nextInt(this.weight[len-1]) + 1;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (this.weight[mid] == randNum) {
                return mid;
            } else if (this.weight[mid] < randNum) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        // LC528 obj = new LC528(new int[]{3, 14, 1, 7});
        LC528 obj = new LC528(new int[]{1, 3});
        int res = obj.pickIndex();
        PrintUtils.printString("res:" + res);
    }
}
