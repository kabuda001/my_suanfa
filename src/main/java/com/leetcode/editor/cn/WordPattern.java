package com.leetcode.editor.cn;
//290:单词规律
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 239 👎 0

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            char[] chars = pattern.toCharArray();
            String[] strings = s.split(" ");
            if (chars.length != strings.length) {
                return false;
            }
            Map<Character, String> map = new HashMap<>();
            Map<String, Character> reMap = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                String s1 = map.get(chars[i]);
                Character s2 = reMap.get(strings[i]);
                if (s1 != null && !s1.equals(strings[i])) {
                    return false;
                }
                if (s2 != null && !s2.equals(chars[i])) {
                    return false;
                }
                map.put(chars[i], strings[i]);
                reMap.put(strings[i], chars[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new WordPattern().new Solution();
    }
}