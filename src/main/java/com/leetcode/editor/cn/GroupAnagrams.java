package com.leetcode.editor.cn;
//49:字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 557 👎 0

import java.util.*;

public class GroupAnagrams {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) {
                return new ArrayList<>();
            }
            Map<String, List> ans = new HashMap<String, List>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(str);
            }
            return new ArrayList(ans.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new GroupAnagrams().new Solution();
    }
}