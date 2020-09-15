package com.leetcode.Array;

public class LC1317 {

    /**
     * 1317. Convert Integer to the Sum of Two No-Zero Integers
     * User Accepted:3510
     * User Tried:3798
     * Total Accepted:3584
     * Total Submissions:6251
     * Difficulty:Easy
     * Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
     *
     * Return a list of two integers [A, B] where:
     *
     * A and B are No-Zero integers.
     * A + B = n
     * It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: [1,1]
     * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
     * Example 2:
     *
     * Input: n = 11
     * Output: [2,9]
     * Example 3:
     *
     * Input: n = 10000
     * Output: [1,9999]
     * Example 4:
     *
     * Input: n = 69
     * Output: [1,68]
     * Example 5:
     *
     * Input: n = 1010
     * Output: [11,999]
     *
     */
    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        int j = n-1;

        int[] res = new int[2];

        while(i <= j) {
            if (validNumber(i) && validNumber(j)) {
                res[0] = i;
                res[1] = j;
                break;
            } else {
                i++;
                j--;
            }
        }
        return res;
    }

    private boolean validNumber(int num) {
        if (num == 0) {
            return false;
        }
        while(num != 0) {
            int carry = num % 10;
            if (carry == 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
