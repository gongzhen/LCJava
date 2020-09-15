package com.leetcode.Heap;

import com.leetcode.Helper.PrintUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder1 {
    private PriorityQueue<Integer> small = new PriorityQueue(1, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        };
    });

    private PriorityQueue<Integer> large = new PriorityQueue();
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}

class MedianFinder {
    /** initialize your data structure here. */
    private PriorityQueue<Integer> left; // top is the largest number
    private PriorityQueue<Integer> right; // top is the smallest number
    public MedianFinder() {
        left = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        right = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void addNum(int num) {
        // left pq holds the small numbers.
        if (left.size() == 0 || left.peek() >= num) {
            left.offer(num);
        } else {
            // right pq holds the large numbers.
            right.offer(num);
        }
        // left = right OR left = right + 1
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }
        if (right.size() > left.size() + 1) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        int leftLen = left.size();
        int rightLen = right.size();
        if (((leftLen + rightLen) & 1) == 1) { // oven
            if (leftLen > rightLen) {
                double res = (double)left.peek();
                return res;
            } else {
                double res = (double)right.peek();
                return res;
            }
        } else { // odd
            double leftRes = (double)left.peek();
            double rightRes = (double)right.peek();
            return (leftRes + rightRes) / 2.0;
        }
    }

    public void printQueue() {
        while(!left.isEmpty()) {
            PrintUtils.printString("left: " + left.poll());
        }

        while(!right.isEmpty()) {
            PrintUtils.printString("right: " + right.poll());
        }
    }
}

public class LC295 {
    public static void main(String[] args) {
//        MedianFinder1 obj = new MedianFinder1();
        MedianFinder obj = new MedianFinder();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7}; // -3, -1, 1, 3, 3,

        for(int i = 0; i < nums.length; i++) {
            obj.addNum(nums[i]);
        }
        PrintUtils.printString("median: " + obj.findMedian());
        obj.printQueue();
    }
}
