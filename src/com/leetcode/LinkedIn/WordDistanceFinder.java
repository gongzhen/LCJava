package com.leetcode.LinkedIn;


import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 *
 *
 * This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox", "the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class WordDistanceFinder {

    private List<String> words;
    public WordDistanceFinder (List<String> words) {
        // implementation here
        this.words = words;
    }

    // wordOne: quick, wordTwo: fox
    public int distance (String wordOne, String wordTwo) {
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int min = this.words.size();
        for(String word : this.words) {
            if (word.equals(wordOne)) {
                if (map.containsKey(wordTwo)) {
                    int wordTwoIndex = map.get(wordTwo);
                    if (min > Math.abs(i - wordTwoIndex)) {
                        min = Math.abs(i - wordTwoIndex);
                    }
                }
            }

            if (word.equals(wordTwo)) {
                if (map.containsKey(wordOne)) {
                    int wordOneIndex = map.get(wordOne);
                    if (min > Math.abs(i - wordOneIndex)) {
                        min = Math.abs(i - wordOneIndex);
                    }
                }
            }

            map.put(word, i);
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        WordDistanceFinder obj = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
        int res = obj.distance("fox", "the"); // 3
        PrintUtils.printString("res: " + res);
        res = obj.distance("quick", "fox"); // 3
        PrintUtils.printString("res: " + res);
    }
}
