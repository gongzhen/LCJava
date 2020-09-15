package com.leetcode.AMAZONOA;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/*
*
You have been given a task of reordering some data from a log file.
Every line in the log file is a space delimited list of strings and all
lines begin with an identifier that is alphanumeric. After the identifier,
a line will consist of either a list of words using only English letters or
only a list of integers. There will be no lines that consist of only an identifier.

Your task is to reorder the data from the log file such that all the lines
with words are at the top in the log file. in lexicographical order. Words are
ordered lexicographically ignoring the identifier except in the case of ties.
In the case of ties (if there are two lines that are identical except for the identifier),
the identifier is used to order lexicographically. Alphanumerics should be sorted in
ASCII order (numbers come before letters). The identifiers must still be part of the
lines in the output Strings. Lines with integers do not need to be sorted relative to other lines with integers.

Write an algorithm to reorder the data in the log file.

The input to the function/method consists of two arguments -

logFileSize: an integer representing the number of lines in the log file,
logLines: a list of strings representing the log file.

Output:
Return a list of strings representing the reordered log file data.

Note:
Identifier consists of only English letters and numbers. The lines with words are not
required to match case and the sort needs to be case insensitive.

Example:
Input:
logFileSize = 5
logLines =
[al 9 2 3 1]
[g1 Act car]
[zo4 4 7]
[abl off KEY dog]
[a8 act zoo]

Output:
[gl Act car]
[a8 act zoo]
[ab1 off KEY dog]
[al 9 2 3 1]
[zo4 4 7]

Explanation:
Second, fourth. and fifth lines are the lines with words. According to the lexicographical order,
the second line will be reordered first in the log file, then fifth, and the fourth comes in the log file. Next, the lines with numbers come in the order in which these lines were in the input.
*/
public class REORDERLOGFILES {

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return new String[]{};
        }

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");
                String w1 = s1[1];
                String w2 = s2[1];
                if (isDigit(w1) == false && isDigit(w2) == false) {
                    int i = 1;
                    int j = 1;
                    while(i < s1.length && j < s2.length) {
                        w1 = s1[i];
                        w2 = s2[j];
                        if (w1.compareTo(w2) == 0) {
                            i++;
                            j++;
                        } else {
                            return w1.compareTo(w2);
                        }
                    }
                    if (i == s1.length && j == s2.length) {
                        return s1[0].compareTo(s2[0]);
                    } else if (i < s1.length) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    // digitLetter
                    if (isDigit(w1) == true && isDigit(w2) == true) {
                        return 1;
                    } else if (isDigit(w1) == true) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return logs;
    }

    private boolean isDigit(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // String[] logs = new String[]{"6p tzwmh ige mc", "ns 566543603829","s 1088746413789","ah4 4209164350"};
        // "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        String[] logs = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        REORDERLOGFILES obj  = new REORDERLOGFILES();
        String[]results = obj.reorderLogFiles(logs);
        // [[0]6p tzwmh ige mc, [1]s 1088746413789, [2]ah4 4209164350, [3]ns 566543603829, ]
        PrintUtils.printStringArray(results);
    }
}
