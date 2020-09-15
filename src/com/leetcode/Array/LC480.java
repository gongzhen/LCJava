package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC480 {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++) {
            if(maxHeap.size() == 0 || maxHeap.peek() < nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            if( minHeap.size() > maxHeap.size() ) {
                maxHeap.add(minHeap.poll());
            }

            if( maxHeap.size() > minHeap.size() + 1 ) {
                minHeap.add(maxHeap.poll());
            }
            PrintUtils.printString("" + minHeap.peek());
            PrintUtils.printString("" + maxHeap.peek());
        }
        return result;
    }

    public double[] medianSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0) {
            return new double[0];
        }
        //
        int len = nums.length - k + 1;
        double[] res = new double[len];

        int[] window = new int[k];
        for(int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window); // -1, 1, 3 -> 1

        for(int i = k; i <= nums.length; i++) {
            // res[i-k] =
            res[i - k] = ((double)window[k / 2] + window[(k - 1)/2]) / 2;
            if (i == nums.length)
                break;
            remove(window, nums[i - k]);
            insert(window, nums[i]);
        }
        return res;
    }

    // Insert val into window, window[k - 1] is empty before inseration
    private void insert(int[] window, int val) {
        int i = 0;
        while (i < window.length - 1 && val > window[i]) {
            ++i;
        }
        int j = window.length - 1;
        while (j > i) {
            window[j] = window[--j];
        }
        window[j] = val;
    }

    // Remove val from window and shrink it.
    private void remove(int[] window, int val) {
        int i = 0;
        while (i < window.length && val != window[i]) {
            ++i;
        }
        while (i < window.length - 1) {
            window[i] = window[++i];
        }
    }

    public static void main(String[] args) {
        LC480 obj = new LC480();
        double[] res = obj.medianSlidingWindow1(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        PrintUtils.printDoubleArray(res);
    }
}
