package com.leetcode.yelp;

import com.leetcode.Helper.PrintUtils;

import java.util.HashMap;

/**
 *
 * 3. Business Response‍‌‌‌‌‌‍‌‍‌‌ Rate
 * 输入一堆Messages，其中包括发送人ID，收件人ID和对话ID。要求输出某一个ID对他收到的信息进行回复的比率。
 *     举个例子：42号给1号发了一个信息，1号又给42号发了一个信息，并且两条信息是同一个对话ID，那么视为1号回复了42号。
 *
 *     解法：
 *     1. 遍历第一遍，用一个Map存储该ID发送的所有信息的对话ID和收件人，用另一个Map存储该ID收到的所有信息的对话ID和发件人。
 *     2. 遍历收到信息的Map，在发送的Map中查找是否有回复。
 */
public class YelpBussinessResponseRate {

    private static class MyMessage {
        public int sender;
        public int recipient;
        public int conversation_id;

        public MyMessage(int s, int r, int c) {
            sender = s;
            recipient = r;
            conversation_id = c;
        }
    }

    public int bussinessResonsivenessRate(int biz_owner, MyMessage[] messages) {
        double res = 0;
        HashMap<Integer, Integer> receive = new HashMap<>();
        HashMap<Integer, Integer> response = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].sender == biz_owner) {
                if (!response.containsKey(messages[i].conversation_id)) {
                    response.put(messages[i].conversation_id, messages[i].recipient);
                }
            }
            if (messages[i].recipient == biz_owner) {
                if (!receive.containsKey(messages[i].conversation_id)) {
                    receive.put(messages[i].conversation_id, messages[i].sender);
                }
            }
        }

        for (Integer i : receive.keySet()) { // conversaion ID
            if (response.containsKey(i)) {   //
                if (response.get(i).equals(receive.get(i))) { // recipient == sender
                    res++;
                }
            }
        }

        res = res / receive.size() * 100;
        return (int)res;
    }

    public static void main(String[] args) {
        YelpBussinessResponseRate obj = new YelpBussinessResponseRate();
        MyMessage[] messages = new MyMessage[6];
        int[] sender = {1, 42, 2, 2, 3, 3};
        int[] recipient = {42, 1, 42, 42, 88, 42};
        int[] con = {1, 1, 2, 2, 3, 4};
        for (int i = 0; i < 6; i++) {
            messages[i] = new MyMessage(sender[i], recipient[i], con[i]);
        }
        int res = obj.bussinessResonsivenessRate(1, messages);
        PrintUtils.printString("res:" + res);
    }
}
