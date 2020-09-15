package com.leetcode.Airbnb;

import com.leetcode.Helper.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public String parseCSV(String str) {
        List<String> res = new ArrayList<>();
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            PrintUtils.printString("" + str.charAt(i));
            if (inQuote) {
                if (str.charAt(i) == '\"') {
                    if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
                        sb.append("\"");
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    sb.append(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    res.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(str.charAt(i));
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return String.join("|", res);
    }

    public static void main(String[] args) {
        String s = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1 \"\"\"Alexandra Alex\"\"\"";
        /////   \"\"\" ==>
        /// Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1 "Alexandra Alex"
        PrintUtils.printString("res:" + s);
        CSVParser obj = new CSVParser();
        PrintUtils.printString("res:" + obj.parseCSV(s));
    }
}
