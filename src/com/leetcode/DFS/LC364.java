package com.leetcode.DFS;

import com.leetcode.Interface.NestedInteger;

import java.util.*;

/***
 *
 * Description
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list – whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1’s at depth 1, one 2 at depth 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 13 + 42 + 6*1 = 17)
 *
 *              [[1,1], 2, [1,1]]   1
 *          [1, 1],   2,    [1, 1]      1 + 1
 *        1, 1               1, 1     1 + 1 + 0
 *
 */

// https://eugenejw.github.io/2017/08/leetcode-364.html
public class LC364 {
    int maxLevel = 0;

    Map<Integer, List<Integer>> map = new HashMap<>();

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxLevel = bfsLevel(nestedList);
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for(int i = 0; i < nestedList.size(); i++) {
            queue.offer(nestedList.get(i));
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                NestedInteger obj = queue.poll();
                if(obj.isInteger()) {
                    sum += obj.getInteger() * maxLevel;
                } else {
                    List<NestedInteger> list = obj.getList();
                    for(NestedInteger l : list) {
                        queue.offer(l);
                    }
                }
            }
        }
        return sum;
    }

    public int depthSumInverse_2(List<NestedInteger> nestedList) {
        int sum = 0;
        dfsLevel_2(nestedList, 1);
        for(int level: map.keySet()) {
            for(int num : map.get(level)) {
                sum += num * (maxLevel - level + 1);
            }
        }
        return sum;
    }

    private void dfsLevel_2(List<NestedInteger> nestedList, int level) {
        if (nestedList.size() == 0) {
            return;
        }

        maxLevel = Math.max(maxLevel, level);
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<Integer>());
        }

        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger obj = nestedList.get(i);
            if(obj.isInteger()) {
                map.get(level).add(obj.getInteger());
            } else {
                dfsLevel_2(obj.getList(), level + 1);
            }
        }
    }

    private int bfsLevel(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger obj : nestedList) {
            queue.offer(obj);
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasList = false;
            for(int i = 0; i < size; i++) {
                NestedInteger node = queue.poll();
                if (node.isInteger() == false) {
                    List<NestedInteger> nodeList = node.getList();
                    for(int j = 0; j < nodeList.size(); j++) {
                        queue.offer(nodeList.get(j));
                    }
                    hasList = true;
                }
            }
            if (hasList == true) {
                level++;
            }
        }
        return level;
    }

    private void dfsLevel(List<NestedInteger> nestedList, int level) {
        int i = 0;
        while (i < nestedList.size()) {
            NestedInteger obj = nestedList.get(i);
            i++;
            if (obj.isInteger()) {
                maxLevel = Math.max(maxLevel, level);
            } else {
                dfsLevel(obj.getList(), level + 1);
            }
        }
    }
}
