package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.*;

/*
*
“Find pair that sum is less or equal to given K from two arrays.”
The detail was like following.

There are two kinds of applications -(foreground, background)
The application has own memory usage. A system has to execute the two sort of application simultaneously. The system has limited memory capacity. Find pairs of application which uses maximum memory usage under the system memory limitation from given two arrays.

Actually, the question was “Find pair that sum is less or equal to given K from two arrays.”.
Output returns indexes of foreground and background applications as vector<pair <int,int>> type.

input :  foreground { {1,2},{2,4},{3,1},{4,5}}
            background {{1,1},{2,3},{3,2}}
            K =5
output : {{1,2},{2,1}}

input :  foreground { {1,2},{2,4}}
            background {{1,1}}
            K =4
output : {{1,1}}

Give a computer with total K memory space, and an array of foreground tasks and
background tasks the computer need to do. Write an algorithm to find a pair of
tasks from each array to maximize the memory usage. Notice the tasks could be done
without origin order.
Input The input to the function/method consists of three arguments : foregroundTask,
an array representing the memory usage of the foreground tasks, backgroundTask, an
array representing the memory usage of the background tasks, K, the total memory space of the computer.
Output Return a list of pairs of the task ids.
Examples 1 Input: foregroundTasks = [1, 7, 2, 4, 5, 6] backgroundTasks = [3, 1, 2] K = 6
Output: [(3, 2), (4, 1)]
Explaination: Here we have 5 foreground tasks: task 0 uses 1 memeory. task 1 uses 7 memeory.
task 2 uses 2 memeory… And 5 background tasks: task 0 uses 3 memeory. task 1 uses 1 memeory.
task 2 uses 2 memeory… We need to find two tasks with total memory usage sum <= K. So we find
the foreground task 3 and background task 2. Total memory usage is 6. 
And the foreground task 4 and background task 1. Total memory usage is also 6.

Examples 2
Input: foregroundTasks = [1, 7, 2, 4, 5, 6] 
backgroundTasks = [3, 1, 2] 
K = 10
Output: [(1, 2)]
Explaination: Here we find the foreground task 1 and background task 2.
Total memory usage is 7 + 2 = 9, which is < 10.

*
*/
public class LC4_AMAZON {
    private static class Pair {
        int id;
        int val;
        public Pair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
    public List<List<Integer>> aircraftUtilization(int[][] background, int[][] foreground, int k) {
        List<Pair> back = new ArrayList<Pair>();
        for (int[] list : background) {
            back.add(new Pair(list[0], list[1]));
        }
        List<Pair> fore = new ArrayList<Pair>();
        for (int[] list : foreground) {
            fore.add(new Pair(list[0], list[1]));
        }

        back.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        fore.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val == o2.val) {
                    return 0;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        /*
        *
        * input :  foreground { {1,2},{2,4},{3,1},{4,5} } => { {3,1},{1,2},{2,4},{4,5} }
            background {{1,1},{2,3},{3,2}} => {{1,1}, {3,2}, {2,3}}
            K = 5
            output : {{1,2},{2,1}}
        */

        List<List<Integer>> result = null;
        int i = 0;
        int j = background.length - 1;
        int max = 0;
        while(i < foreground.length && j >= 0) {
            int sum = fore.get(i).val + back.get(j).val;
            if (sum > max && sum <= k) {
                max = sum;
                result = new ArrayList<>();
                result.add(new ArrayList<Integer>(Arrays.asList(fore.get(i).id, back.get(j).id)));
                i++;
            } else if (sum == max) {
                result.add(new ArrayList<Integer>(Arrays.asList(fore.get(i).id, back.get(j).id)));
                i++;
            } else {
                j--;
            }
        }
        return result;
//        Map<Integer, List<List<Integer>>> map = new HashMap<>();
//        int i = 0;
//        int j = background.length - 1;
//        int max = 0;
//        while (i < foreground.length && j >= 0) {
//            int sum = fore.get(i).val + back.get(j).val;
//            if (sum > k) {
//                j--;
//            } else {
//                if (max <= sum) {
//                    max = sum;
//                    map.putIfAbsent(sum, new ArrayList<>());
//                    int l = j;
//                    while(l >= 0 && (fore.get(i).val + back.get(l).val == sum)) {
//                        List<Integer> indexList = new ArrayList<>();
//                        indexList.add(fore.get(i).id);
//                        indexList.add(back.get(l).id);
//                        map.get(sum).add(indexList);
//                        l--;
//                    }
//                }
//                i++;
//            }
//        }
//        return map.get(max);
    }

    public static List<List<Integer>> calculateOptimalRoute(final List<List<Integer>> forwardList, final List<List<Integer>> returnList,int capacity)
    {

        // sort forward list
        Collections.sort(forwardList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        // sort return list
        Collections.sort(returnList, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        int max = 0;
        int i = 0;
        int j = returnList.size() - 1;

        List<List<Integer>> result = null;
        while(i < forwardList.size() && j >= 0) {
            int currentSum = forwardList.get(i).get(1) + returnList.get(j).get(1);

            if ( currentSum> max && currentSum <= capacity) {
                max = forwardList.get(i).get(1) + returnList.get(j).get(1);
                result = new LinkedList<List<Integer>>();
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
            }
            else if(forwardList.get(i).get(1) + returnList.get(j).get(1) == max)
            {
                // no need to reset result list
                result.add(new ArrayList<Integer>(Arrays.asList(forwardList.get(i).get(0), returnList.get(j).get(0))));
                i++;
            } else
            {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC4_AMAZON obj = new LC4_AMAZON();
        List<List<Integer>> result = obj.aircraftUtilization(new int[][]{{1,2},{2,4},{3,1},{4,5}}, new int[][]{{1,1},{2,3},{3,2}}, 5);
        PrintUtils.printListOfListInteger(result);
    }
}
