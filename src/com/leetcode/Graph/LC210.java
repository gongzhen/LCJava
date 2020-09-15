package com.leetcode.Graph;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

public class LC210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            return null;
        }
        // [nextCourse, firstCourse]
        //      <----- order
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] courses : prerequisites) { //
            if (!graph.containsKey(courses[1])) {
                graph.put(courses[1], new ArrayList<>());
            }
            graph.get(courses[1]).add(courses[0]);
        }
        int[] indegrees = new int[numCourses];
        for(int[] courses : prerequisites) {
            indegrees[courses[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while(!queue.isEmpty()) {
            int nextCourse = queue.poll();
            resList.add(nextCourse);
            if(graph.containsKey(nextCourse)) {
                List<Integer> nextCourseNextList = graph.get(nextCourse);
                for(int nextIndegree: nextCourseNextList) {
                    indegrees[nextIndegree]--;
                    if (indegrees[nextIndegree] == 0) {
                        queue.offer(nextIndegree);
                    }
                }
            }
        }
        if (resList.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[resList.size()];
        int i = 0;
        for(int n : resList) {
            res[i++] = n;
        }
        return res;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] indegree = new int[numCourses];
        makeGraph(graph, numCourses, prerequisites, indegree);

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // int[] res = new int[numCourses];
        // int index = 0;
        List<Integer> resList = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            int s = queue.poll();
            resList.add(s);

            for(int n : graph.get(s)) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        int[] res = new int[numCourses];
        // dont forget here.
        if(resList.size() != numCourses) {
            return new int[0];
        }

        for(int i = 0; i < numCourses; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void makeGraph(List<List<Integer>> graph, int numCourses, int[][] prerequisites, int[] indegree) {
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] list : prerequisites) {
            graph.get(list[1]).add(list[0]);
            indegree[list[0]]++;
        }
    }

    public static void main(String[] args) {
        LC210 obj = new LC210();
        // int[0][0]
        int[] res = obj.findOrder(2, new int[0][0]);
//        int[] res = obj.findOrder2(2, new int[][]{{}});
        res = obj.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        PrintUtils.printArray(res);
    }
}
