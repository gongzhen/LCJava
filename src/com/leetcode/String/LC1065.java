package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;
import com.leetcode.Tree.LC106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1065.Index Pairs of a String
 * Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.
 * Example 1:
 *
 * Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * Example 2:
 *
 * Input: text = "ababa", words = ["aba","ab"]
 * Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation:
 * Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
 * Note:
 *
 * All strings contains only lowercase English letters.
 * It's guaranteed that all strings in words are different.
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them by their second coordinate).
 */
public class LC1065 {

    public List<List<Integer>> indexPairs(String text, List<String> words) {
        List<List<Integer>> res = new ArrayList<>();
        for(String word : words) {
            if (text.contains(word)) {
                int s = text.indexOf(word);
                res.add(new ArrayList<Integer>(Arrays.asList(s, s + word.length() - 1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1065 obj = new LC1065();
        List<List<Integer>> res = obj.indexPairs("thestoryofleetcodeandme", new ArrayList<String>(Arrays.asList("story","fleet","leetcode")));
        PrintUtils.printListOfListInteger(res);
    }
}
