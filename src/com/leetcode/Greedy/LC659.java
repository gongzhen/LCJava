package com.leetcode.Greedy;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC659 {

    /**
     *
     * https://blog.csdn.net/JackZhang_123/article/details/78866342
     *
     * https://www.jianshu.com/p/b910737af4dc
     *
     *
     * Solution
     * Greedy, time O(n), space O(n)
     * 先遍历数组得到每个num出现的frequency。
     * 对于每个num来说，要么将它append到已经成型的sequence中，
     * 要么以它为起点开辟一个新的长度为3的sequence。如果两者皆不可行，则返回false。
     *
     * 这道题就用贪婪解法就可以了，我们使用两个哈希表map，
     * 第一个map用来建立数字和其出现次数之间的映射freq，
     * 第二个用来建立可以加在某个连续子序列后的数字及其可以出现的次数之间的映射need。
     * 对于第二个map，举个例子来说，就是假如有个连，[1,2,3]，那么后面可以加上4，所以就建立4的映射。
     * 这样我们首先遍历一遍数组，统计每个数字出现的频率，然后我们开始遍历数组，对于每个遍历到的数字，
     * 首先看其当前出现的次数，如果为0，则继续循环；
     * 如果need中存在这个数字的非0映射，那么表示当前的数字可以加到某个连的末尾，
     * 我们将当前数字的映射值自减1，然后将下一个连续数字的映射值加1，
     * 因为当[1,2,3]连上4后变成[1,2,3,4]之后，就可以连上5了；
     *
     * 如果不能连到其他子序列后面，我们来看其是否可以成为新的子序列的起点，
     * 可以通过看后面两个数字的映射值是否大于0，
     * 都大于0的话，说明可以组成3连儿，于是将后面两个数字的映射值都自减1，
     * 还有由于组成了3连儿，在need中将末尾的下一位数字的映射值自增1；
     * 如果上面情况都不满足，说明该数字是单牌，只能划单儿，直接返回false。
     * 最后别忘了将当前数字的freq映射值自减1。退出for循环后返回true，
     *
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> append = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for(int n : nums) {
            if (freq.get(n) == 0) {
                continue;
            } // freq.get(n) > 0
            if(append.getOrDefault(n, 0) > 0) {
                // append to an exsiting consecutive sequence
                freq.put(n, freq.get(n) - 1);
                append.put(n, append.get(n) - 1);
                append.put(n + 1, append.getOrDefault(n, 0) + 1);
            } else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
                // create a new consecutive sequence of 3 elements
                freq.put(n, freq.get(n) - 1);
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1); // 1, 2, 3
                append.put(n + 3, append.getOrDefault(n + 3, 0) + 1); // 4
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LC659 obj = new LC659();
        boolean res = obj.isPossible(new int[]{1,2,3,3,4,4,5,5});
        PrintUtils.printBool(res);
    }
}
