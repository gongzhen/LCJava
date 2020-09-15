package com.leetcode.Heap;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(this.k, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        });
        for(int n : nums) {
            this.pq.offer(n);
            if(pq.size() == this.k + 1) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        this.pq.offer(val);
        if (this.pq.size() == this.k + 1) {
            this.pq.poll();
        }
        int res = this.pq.peek();
        return res;
    }
}

public class LC703 {

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        int res = obj.add(3);
        PrintUtils.printString("res:" + res);
        res = obj.add(5);
        PrintUtils.printString("res:" + res);
        res = obj.add(10);
        PrintUtils.printString("res:" + res);
        res = obj.add(9);
        PrintUtils.printString("res:" + res);
    }
}
