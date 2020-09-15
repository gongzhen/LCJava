package com.leetcode.HashTable;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class LC535 {

    // https://github.com/zxqiu/leetcode-lintcode/blob/master/system%20design/Tiny_Url_I_II.java

    private static class Codec {
        private Map<String, String> shortToLong;
        private Map<String, String> longToShort;
        private static final String prefix = "http://tiny.url/";
        private static long count = 0;

        public Codec() {
            this.shortToLong = new HashMap<>();
            this.longToShort = new HashMap<>();
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if(longToShort.containsKey(longUrl)) {
                return longToShort.get(longUrl);
            }

            String shortURL = prefix + hashLong(longUrl);
            longToShort.put(longUrl, shortURL);
            shortToLong.put(shortURL, longUrl);
            return shortURL;
        }

        private String hashLong(String longURL) {
            long div = 0, model = 0;
            StringBuilder sb = new StringBuilder();
            div = count++; /// div will start from 0, 1, 2, .....
            int digits = 0;
            // 0, 1, 2, 3, ...9 == 10
            // a, b, c, ......z == 26
            // A, B, C, ......Z == 26
            // total is 62.
            while(true) {
                model = div % 62;
                div = div / 62;

                char c = '0';
                if(model >= 0 && model <= 9) {
                    c = (char)(model + '0');
                } else if (model >= 10 && model <= 36) {
                    c = (char)(model - 10 + 'a');
                } else {
                    c = (char)(model - 36 + 'A');
                }
                sb.insert(0, c);
                digits++;
                if(div > 0 || digits < 6) { /// digits can be any number. I put 12 and it passes the leetcode oj.
                    break;
                }
            }
            return sb.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if(shortToLong.containsKey(shortUrl)) {
                return shortToLong.get(shortUrl);
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec obj = new Codec();
        PrintUtils.printString("res:" + obj.encode(url)); // res:http://tiny.url/0
        PrintUtils.printString("res:" + obj.decode(obj.encode(url))); // res:http://tiny.url/0
    }
}
