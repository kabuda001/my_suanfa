package com.leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 342 👎 0

import java.util.*;

public class P140WordBreakIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            // key - 当前字母的在 s 中的索引
            // value - 其中每个索引均满足与当前字母索引之间的单词在 wordDict 中
            Map<Integer, Set<Integer>> breakIndexMap = new HashMap<>();
            breakIndexMap.put(0, new HashSet<>());
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (breakIndexMap.containsKey(j) && wordDict.contains(s.substring(j, i))) {
                        Set<Integer> breakIndex = breakIndexMap.getOrDefault(i, new HashSet<>());
                        breakIndex.add(j);
                        breakIndexMap.put(i, breakIndex);
                    }
                }
            }
            return genSentence(s, breakIndexMap, n);
        }

        private List<String> genSentence(String s, Map<Integer, Set<Integer>> breakIndexMap, int endIndex) {
            List<String> sentenceList = new ArrayList<>();
            if (endIndex == 0) {
                return sentenceList;
            }
            Set<Integer> beginIndexSet = breakIndexMap.get(endIndex);
            if (beginIndexSet == null || beginIndexSet.isEmpty()) {
                return sentenceList;
            }
            for (int beginIndex : beginIndexSet) {
                String word = s.substring(beginIndex, endIndex);
                List<String> subSentenceList = genSentence(s, breakIndexMap, beginIndex);
                if (subSentenceList.isEmpty()) {
                    sentenceList.add(word);
                } else {
                    for (String s1 : subSentenceList) {
                        sentenceList.add(s1 + " " + word);
                    }
                }
            }
            return sentenceList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P140WordBreakIi().new Solution();
    }
}