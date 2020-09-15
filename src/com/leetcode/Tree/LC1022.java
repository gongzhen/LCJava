//package com.leetcode.Tree;
//
//import com.leetcode.Helper.PrintUtils;
//import com.leetcode.Helper.TreeNode;
//import com.leetcode.Helper.TreeUtils;
//       int[] map = new int[64];
//               for(int i = 0; i < 64; i++) {
//               map[i] = 0;
//               }
//
//               for (char c : t.toCharArray()) {
//               map[c - 'A']++;
//               }
//
//               char[] chars = s.toCharArray();
//               int count = t.length();
//               int i = 0;
//               int j = 0;
//               int min = s.length() + 1;
//               String result = "";
//               while ( i < chars.length) {
//               char c = chars[i];
//               if (map[c - 'A'] > 0) {
//               count--;
//               }
//               map[c-'A']--;
//               i++;
//               while(count == 0) {
//               if (min > i - j) {
//               min = i - j;
//               result = s.substring(j, i);
//               }
//               c = chars[j];
//               if (map[c - 'A'] == 0) {
//               count++;
//               }
//               map[c - 'A']++;
//               j++;
//               }
//               }
//               return result;
//public class LC1022 {
//    public int sumRootToLeaf(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode node, int num) {
//        if (node == null) {
//            return 0;
//        }
//
////        num = num * 2 + node.val; ///  * 1 * 2 + 0 ==> 2
//        num = num * 10 + node.val; /// 1 * 10 + 0 ==> 10
//        int binaryNum = convertBinaryToInt(num);
//        if (node.left == null && node.right == null) {
//            // return convertBinaryToInt(num);
//            return binaryNum;
//        }
//        return dfs(node.left, num) + dfs(node.right, num);
//    }
//
//    public int convertBinaryToInt(int number) {
//        int result = 0;
//        int bit = 0;
//        while (number != 0) {
//            int carry = number % 10;
//            if (carry != 0 && carry != 1) {
//                return 0;
//            }
//            if (carry == 1) {
//                result = result + (int)Math.pow(2, bit);
//            }
//            ++bit;
//            number = number / 10;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        LC1022 obj = new LC1022();
//        TreeNode root = TreeUtils.LC1022createTree();
//        TreeUtils.printTreeByLevel(root);
//        int res = obj.sumRootToLeaf(root);
//        PrintUtils.printString("res:" + res);
//    }
//}
