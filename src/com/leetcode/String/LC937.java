package com.leetcode.String;
import com.leetcode.Helper.*;
import com.leetcode.Tree.LC94;

import java.util.*;

public class LC937 {

    public String[] reorderLogFiles1(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si+1);
                char s2fc = s2.charAt(s2si+1);

                if (s1fc <= '9') {
                    if (s2fc <= '9') {
                        return 0;
                    }
                    else {
                        return 1;
                    }
                }
                if (s2fc <= '9') {
                    return -1;
                }

                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (preCompute == 0) {
                    return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                }
                return preCompute;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<String>();
        List<String> digitList = new ArrayList<String>();

        for (String log : logs) {
            String[] splitWords = log.split(" ");
            String firstWord = splitWords[1];
            if (isNumber(firstWord) == true) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        Collections.sort(letterList, new StringComparator());
        Collections.sort(digitList, new StringComparator());
        String[] result = new String[logs.length];
        int i = 0;
        for (i = 0; i < letterList.size(); i++) {
            result[i] = letterList.get(i);
        }
        for (int j = 0; j < digitList.size(); j++) {
            result[i] = digitList.get(j);
            i++;
        }
        return result;
    }

    public boolean isNumber(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String[] splitWords1 = s1.split(" ");
            String[] splitWords2 = s2.split(" ");
            int i = 1;
            int j = 1;
            while(i < splitWords1.length && j < splitWords2.length) {
                String w1 = splitWords1[i];
                String w2 = splitWords2[j];
                if (w1.equals(w2)) {
                    i++;
                    j++;
                } else {
                    return w1.compareTo(w2);
                }
            }

            if (i == splitWords1.length && j == splitWords2.length){
                return splitWords1[0].compareTo(splitWords2[0]);
            } else if (i < splitWords1.length) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
//        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
//        String[] logs = new String[]{"g1 act car", "a8 act zoo"};
        // ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"]
        // ["6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"]
//        String[] logs = new String[]{"g1 act car","a2 act car"};
//        String[] logs = new String[]{"6p tzwmh ige mc", "ns 566543603829","s 1088746413789","ah4 4209164350"};
        // "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        String[] logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        LC937 obj  = new LC937();
        String[]results = obj.reorderLogFiles1(logs);
        PrintUtils.printStringArray(results);
    }
}
