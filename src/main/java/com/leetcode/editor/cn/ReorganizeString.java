package com.leetcode.editor.cn;
//767:重构字符串
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 162 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            if (S.length() < 2) {
                return S;
            }
            int[] counts = new int[26];
            int maxCount = 0;
            int length = S.length();
            for (int i = 0; i < length; i++) {
                char c = S.charAt(i);
                counts[c - 'a']++;
                maxCount = Math.max(maxCount, counts[c - 'a']);
            }
            if (maxCount > (length + 1) / 2) {
                return "";
            }
            PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> counts[letter2 - 'a'] - counts[letter1 - 'a']);
            for (char c = 'a'; c <= 'z'; c++) {
                if (counts[c - 'a'] > 0) {
                    queue.offer(c);
                }
            }
            StringBuffer sb = new StringBuffer();
            while (queue.size() > 1) {
                char letter1 = queue.poll();
                char letter2 = queue.poll();
                sb.append(letter1);
                sb.append(letter2);
                int index1 = letter1 - 'a', index2 = letter2 - 'a';
                counts[index1]--;
                counts[index2]--;
                if (counts[index1] > 0) {
                    queue.offer(letter1);
                }
                if (counts[index2] > 0) {
                    queue.offer(letter2);
                }
            }
            if (queue.size() > 0) {
                sb.append(queue.poll());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReorganizeString().new Solution();
    }
}