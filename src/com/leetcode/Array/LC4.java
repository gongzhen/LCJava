package com.leetcode.Array;

public class LC4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0) {
            return (partition(nums1, 0, nums2, 0, len / 2)
            + partition(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }

        return partition(nums1, 0, nums2, 0, len / 2 + 1);
    }

    private double partition(int[] nums1, int s1, int[] nums2, int s2, int k) {
        int i = s1, j = s2;
        while(i < nums1.length && j < nums2.length) {
            if(k == 1) { // k == 1 is the break condition. the kth largest number from nums1 and nums2 which kth = 1.
                break;
            }
            // i + (k / 2 - 1) < length ? => nums[i + (k / 2 - 1)]
            int mid1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int mid2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
            if(mid1 < mid2) {   // compare mid1 and mid2
                i += k / 2;     // i moves k/2
            } else {
                j += k / 2;     // j moves k/2
            }
            k = k - k / 2;      // k will move k/2
        }
        // if i is beyond the length, then just returns nums from j + k - 1, right now k might not equal 1.
        if(i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if(j >= nums2.length) {
            return nums1[i + k - 1];
        }
        return Math.min(nums1[i], nums2[j]);
    }

    public static void main(String[] args) {
        LC4 obj = new LC4();
        obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
