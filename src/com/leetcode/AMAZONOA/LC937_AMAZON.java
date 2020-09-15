package com.leetcode.AMAZONOA;

/*
*
Most Common Words
Amazon is partnering with the linguistics department at a local university to analyze important works of
English literature and identify patterns in word usage across different eras. To ensure a cleaner output.
the linguistics department has provided a list of commonly used words (e.g., “an”, “the”. etc.)
to exclude from the analysis. In the context of this search, a word is an alphabetic sequence of
characters having no whitespace or punctuation.

Write an algorithm to find the most frequently used word in the text excluding the commonly used words.

Input:
The input to the function/method consists of two arguments:
literatureText: a string representing the block of text,
wordsToExclude: a list of strings representing the commonly used words to be excluded while analyzing the word frequency.

Output:
Return a list of strings representing the most frequently used word in the text or in case of a tie,
all of the most frequently used words in the text..

Note:
Words that have a different case are counted as the same word. The order of words does not matter in the output list.
All words in the ‘wordsToExclude’ list are unique. Punctuation should be treated as white space.

Example
Input :
literature Text = “Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.”
wordsToExclude = [“and”, “he”, “the”, “to”, “is”. “Jack”, “Jill”]
Output :
[“cheese”, “s”]

Explanation : The word `and" has a maximum of three frequency but this word should be excluded while
analyzing the word frequency.
The words “Jack’. 'Jill”, “s”, “to” and “cheese” have the next maximum frequency(two) in the given text but the words “Jack”,
“to” and "Jill’ should be excluded as these are commonly used words which you are not interested to include.
*
*/

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC937_AMAZON {
    public List<String> mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" |\\'|\\.");
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> list = new ArrayList<String>();
        for (String word: words) {
            String lowerCase = word.toLowerCase();
            if (!contains(lowerCase, banned)) {
                list.add(lowerCase);
            }
        }
        int max = 1;
        for (String word : list) {
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count+1);
                if (max < count + 1) {
                    max = count + 1;
                }
            } else {
                map.put(word, 1);
            }
        }
        Map<Integer, List<String>> resultMap = new HashMap<>();
        for (String word : map.keySet()) {
            int count = (int)map.get(word);
            resultMap.putIfAbsent(count, new ArrayList<String>());
            resultMap.get(count).add(word);
        }
        return resultMap.get(max);
    }

    private boolean contains(String word, String[] banned) {
        for (String banword : banned) {
            if (word.equals(banword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] banned = new String[]{"and", "he", "the", "to", "is", "Jack", "Jill"};
        //
        String paragraph = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
        LC937_AMAZON obj  = new LC937_AMAZON();
        List<String>results = obj.mostCommonWord(paragraph, banned);
        PrintUtils.printListString(results);
    }
}
