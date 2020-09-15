package com.leetcode.Array;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;

public class LC128 {

    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int length = left + right + 1;
                map.put(n, length);

                // keep track of the max length
                res = Math.max(res, length);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, length);
                map.put(n + right, length);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC128 obj = new LC128();
        int res = obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        PrintUtils.printString("res:" + res);
    }
}
