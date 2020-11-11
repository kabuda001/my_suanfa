package com.leetcode.editor.cn;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 532 👎 0

import java.util.HashSet;
import java.util.List;

public class P127WordLadder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) {
                return 0;
            }
            HashSet<String> start = new HashSet<>();
            HashSet<String> end = new HashSet<>();
            HashSet<String> dic = new HashSet<>(wordList);
            start.add(beginWord);
            end.add(endWord);
            if (!dic.contains(endWord)) {
                return 0;
            }
            return this.bfs(start, end, dic, 2);
        }

        private int bfs(HashSet<String> st, HashSet<String> en, HashSet<String> dic, int length) {
            // 连接出现断裂
            if (st.size() == 0) {
                return 0;
            }
            if (st.size() > en.size()) {
                // 双端查找，从少的一遍在找
                return this.bfs(en, st, dic, length);
            }
            // 剔除重复的值
            dic.removeAll(st);
            HashSet<String> next = new HashSet<>();
            for (String s : st) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == tmp) {
                            continue;
                        }
                        arr[i] = c;
                        String nsStr = new String(arr);
                        if (dic.contains(nsStr)) {
                            if (en.contains(nsStr)) {
                                return length;
                            } else {
                                next.add(nsStr);
                            }
                        }
                    }
                    // 还原
                    arr[i] = tmp;
                }
            }
            return bfs(next, en, dic, length + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P127WordLadder().new Solution();
    }
}