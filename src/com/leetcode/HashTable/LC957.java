package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        //  [[0]1, [1]0, [2]1, [3]0, [4]0, [5]0, [6]1, [7]0, ]
        return cells;
    }

    public int[] prisonAfterNDays1(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cells.length; i++) {
            map.put(i, cells[i]);
        }
        for(int i = 1; i <= N; i++) {
            update(cells, map);
        }
        return cells;
    }

    private void update(int[] cells, Map<Integer, Integer> map) {
        cells[0] = 0;
        cells[cells.length - 1] = 0;
        for(int i = 1; i < cells.length - 1; i++) {
            if (map.containsKey(i-1) && map.containsKey(i + 1)) {
                int leftV = map.get(i-1);
                int rightV = map.get(i+1);
                if (leftV == rightV) {
                    cells[i] = 1;
                } else {
                    cells[i] = 0;
                }
            }
        }
        for(int i = 0; i < cells.length; i++) {
            map.put(i, cells[i]);
        }
        PrintUtils.printArray(cells);
    }

    public static void main(String[] args) {
        LC957 obj = new LC957();
//        int[] res = obj.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7);
        int[] res = obj.prisonAfterNDays1(new int[]{1,1,0,1,1,0,0,0}, 1);
//        [[0]1, [1]0, [2]1, [3]0, [4]0, [5]0, [6]1, [7]0, ]
//        [[0]1, [1]0, [2]1, [3]0, [4]0, [5]0, [6]1, [7]0, ]
        PrintUtils.printArray(res);
    }
}
