package com.leetcode.Heap;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *
 * Intuition
 *
 * This problem is very similar to something that employees of a company can face potentially on daily basis.
 *
 * Suppose you work at a company and you belong to the IT department and one of your job responsibilities is securing rooms for meetings that are to happen throughout the day in the office.
 *
 * You have multiple meeting rooms in the office and you want to make judicious use of them. You don't really want to keep people waiting and want to give a group of employees a room to hold the meeting right on time.
 *
 * At the same time, you don't really want to use too many rooms unless absolutely necessary. It would make sense to hold meetings in different rooms provided that the meetings are colliding with each other, otherwise you want to make use of as less rooms as possible to hold all of the meetings. How do you go about it ?
 *
 * I just represented a common scenario at an office where given the start and end times for meetings to happen throughout the day, you, as an IT guy need to setup and allocate the room numbers to different teams.
 *
 * Let's approach this problem from the perspective of a group of people who want to hold a meeting and have not been allocated a room yet. What would they do?
 *
 * This group would essentially go from one room to another and check if any meeting room is free. If they find a room that is indeed free, they would start their meeting in that room. Otherwise, they would wait for a room to be free. As soon as the room frees up, they would occupy it.
 *
 * This is the basic approach that we will follow in this question. So, it is a kind of simulation but not exactly. In the worst case we can assign a new room to all of the meetings but that is not really optimal right? Unless of course they all collide with each other.
 *
 * We need to be able to find out efficiently if a room is available or not for the current meeting and assign a new room only if none of the assigned rooms is currently free.
 *
 * Let's look at the first approach based on the idea we just discussed.
 *
 *
 * Approach 1: Priority Queues
 * We can't really process the given meetings in any random order. The most basic way of processing the meetings is in increasing order of their start times and this is the order we will follow. After all if you're an IT guy, you should allocate a room to the meeting that is scheduled for 9 a.m. in the morning before you worry about the 5 p.m. meeting, right?
 *
 * Let's do a dry run of an example problem with sample meeting times and see what our algorithm should be able to do efficiently.
 *
 * We will consider the following meeting times for our example (1, 10), (2, 7), (3, 19), (8, 12), (10, 20), (11, 30). The first part of the tuple is the start time for the meeting and the second value represents the ending time. We are considering the meetings in a sorted order of their start times. The first diagram depicts the first three meetings where each of them requires a new room because of collisions.
 *
 *
 * The next 3 meetings start to occupy some of the existing rooms. However, the last one requires a new room altogether and overall we have to use 4 different rooms to accommodate all the meetings.
 *
 *
 * Sorting part is easy, but for every meeting how do we find out efficiently if a room is available or not? At any point in time we have multiple rooms that can be occupied and we don't really care which room is free as long as we find one when required for a new meeting.
 *
 * A naive way to check if a room is available or not is to iterate on all the rooms and see if one is available when we have a new meeting at hand.
 *
 * However, we can do better than this by making use of Priority Queues or the Min-Heap data structure.
 *
 * Instead of manually iterating on every room that's been allocated and checking if the room is available or not, we can keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.
 *
 * So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.
 *
 * If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and simply allocate a new room.
 *
 * Let us look at the algorithm before moving onto the implementation.
 *
 * Algorithm
 *
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 * Let us not look at the implementation for this algorithm.
 *
 *
 * Complexity Analysis
 *
 * Time Complexity: O(N\log N)O(NlogN).
 *
 * There are two major portions that take up time here. One is sorting of the array that takes O(N\log N)O(NlogN) considering that the array consists of NN elements.
 * Then we have the min-heap. In the worst case, all NN meetings will collide with each other. In any case we have NN add operations on the heap. In the worst case we will have NN extract-min operations as well. Overall complexity being (NlogN)(NlogN) since extract-min operation on a heap takes O(\log N)O(logN).
 * Space Complexity: O(N)O(N) because we construct the min-heap and that can contain NN elements in the worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N).
 *
 *
 * Approach 2: Chronological Ordering
 * Intuition
 *
 * The meeting timings given to us define a chronological order of events throughout the day. We are given the start and end timings for the meetings which can help us define this ordering.
 *
 * Arranging the meetings according to their start times helps us know the natural order of meetings throughout the day. However, simply knowing when a meeting starts doesn't tell us much about its duration.
 *
 * We also need the meetings sorted by their ending times because an ending event essentially tells us that there must have been a corresponding starting event and more importantly, an ending event tell us that a previously occupied room has now become free.
 *
 * A meeting is defined by its start and end times. However, for this specific algorithm, we need to treat the start and end times individually. This might not make sense right away because a meeting is defined by its start and end times. If we separate the two and treat them individually, then the identity of a meeting goes away. This is fine because:
 *
 * When we encounter an ending event, that means that some meeting that started earlier has ended now. We are not really concerned with which meeting has ended. All we need is that some meeting ended thus making a room available.
 *
 * Let us consider the same example as we did in the last approach. We have the following meetings to be scheduled: (1, 10), (2, 7), (3, 19), (8, 12), (10, 20), (11, 30). As before, the first diagram show us that the first three meetings are colliding with each other and they have to be allocated separate rooms.
 *
 *
 * The next two diagrams process the remaining meetings and we see that we can now reuse some of the existing meeting rooms. The final result is the same, we need 4 different meeting rooms to process all the meetings. That's the best we can do here.
 *
 *
 *
 * Algorithm
 *
 * Separate out the start times and the end times in their separate arrays.
 * Sort the start times and the end times separately. Note that this will mess up the original correspondence of start times and end times. They will be treated individually now.
 * We consider two pointers: s_ptr and e_ptr which refer to start pointer and end pointer. The start pointer simply iterates over all the meetings and the end pointer helps us track if a meeting has ended and if we can reuse a room.
 * When considering a specific meeting pointed to by s_ptr, we check if this start timing is greater than the meeting pointed to by e_ptr. If this is the case then that would mean some meeting has ended by the time the meeting at s_ptr had to start. So we can reuse one of the rooms. Otherwise, we have to allocate a new room.
 * If a meeting has indeed ended i.e. if start[s_ptr] >= end[e_ptr], then we increment e_ptr.
 * Repeat this process until s_ptr processes all of the meetings.
 * Let us not look at the implementation for this algorithm.
 *
 * */
public class LC253HP {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        pq.offer(intervals[0]);
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        LC253HP obj = new LC253HP();
        // int res = obj.minMeetingRooms(new int[][]{{13, 15}, {1, 13}});
        int res = obj.minMeetingRooms(new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}});
        PrintUtils.printString("res:" + res);
    }
}
