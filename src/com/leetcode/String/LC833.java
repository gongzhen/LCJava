package com.leetcode.String;

import com.leetcode.Helper.PrintUtils;

import java.util.Arrays;
import java.util.Comparator;

public class LC833 {

    public static class Group {
        int i;
        String s;
        String t;

        public Group(int i, String s, String t) {
            this.i = i;
            this.s = s;
            this.t = t;
        }
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        Group[] groups = new Group[indexes.length];
        for(int i = 0; i < indexes.length; i++) {
            groups[i] = new Group(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(groups, new Comparator<Group>(){
            public int compare(Group a, Group b) {
                if(a.i > b.i) {
                    return 1;
                } else if (a.i == b.i) {
                    return 0;
                }
                return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < groups.length; i++) {
            String source = groups[i].s;
            int startIdx = groups[i].i;
            String subStr = S.substring(startIdx, startIdx + source.length());
            if (subStr.equals(source)) {
                String startString = S.substring(j, startIdx);
                sb.append(startString);
                String target = groups[i].t;
                sb.append(target);
                j = startIdx + source.length();
            }
        }
        sb.append(S.substring(j));
        return sb.toString();
    }

    public static void main(String[] args) {
        LC833 obj = new LC833();
        // String res = obj.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
        String res = obj.findReplaceString("vmokgggqzp",
                new int[]{3,5,1},
                new String[]{"kg","ggq","mo"},
                new String[]{"s","so","bfr"});
        /// vmokgggqzp
        /// vmosggqzp
        /// vmossozp
        /// vbfrssozp
        /// vbfrssozp
        /// vssobfrzp

        PrintUtils.printString("res: " + res);

       /**
        *
        * "vmokgggqzp"
        * [3,5,1]
        * ["kg","ggq","mo"]
        * ["s","so","bfr"]
        *
        * */
    }
}
