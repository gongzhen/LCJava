package com.leetcode.BitManipulation;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 {

    /**
     * https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/
     * */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        /**
         * map['A' - 'A'] = 0;
         * 00 -> 'A'
         * 01 -> 'C'
         * 10 -> 'G'
         * 11 -> 'T'
         *  A  A  C  C  T  C  C  G  G  T
         * 00 00 01 01 11 01 01 10 10 11 = 00000101110101101011 (binary) = 23915 (decimal)
         * */
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2; // Then for each letter we shift V to the left by 2 bits, Line 1: move v left 2 bit, for example 01 after moving 0100.
            // value |= map[s.charAt(i) - 'A'];
            value = value | map[s.charAt(i) - 'A']; // and OR it with the letter representation 00 | 00 = 00, Line 2: Append 2 bits, 0100 | 11 => 0111
            value &= 0xfffff; // Line 3: 0xfffff is 20's 1, aka Window of 10 2bits, the bits exceed 20 bits will be 0.
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC187 obj = new LC187();
        List<String> res = obj.findRepeatedDnaSequences("AACCTCCGGT");
        PrintUtils.printListString(res);
    }
}
