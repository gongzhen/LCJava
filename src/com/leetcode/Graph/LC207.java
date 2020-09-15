package com.leetcode.Graph;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int[] courses = prerequisites[i];
            if (!graph.containsKey(courses[1])) {
                graph.put(courses[1], new ArrayList<Integer>()); // courses[1] -> courses[0]
            }
            graph.get(courses[1]).add(courses[0]);
        }

        int[] indegree = new int[numCourses];
        for(int[] courses : prerequisites) { // courses[1] is the first take course -> courses[0] is the second course.
            indegree[courses[0]]++; // start course ++, next course == 0
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) { // next Course == 0
                queue.offer(i);
            }
        }

        int step = 0;
        while(!queue.isEmpty()) { // queue stores all next Course with 0.
            step++;
            int course = queue.poll();
            List<Integer> nextList = graph.get(course);
            if (nextList != null) {
                for(Integer nextCourse : nextList) { //
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        return step == numCourses;
    }

    public static void main(String[] args) {
        LC207 obj = new LC207();
        boolean res = obj.canFinish(2, new int[][]{{1, 0}});
        PrintUtils.printBool(res);
    }
}
