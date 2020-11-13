package com.leetcode.editor.cn;
//剑指 Offer 05:替换空格
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 48 👎 0

public class TiHuanKongGeLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            int l = s.length();
            char[] chars = new char[l * 3];
            int size = 0;
            for (int i = 0; i < l; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    chars[size++] = '%';
                    chars[size++] = '2';
                    chars[size++] = '0';
                } else {
                    chars[size++] = c;
                }
            }
            return new String(chars, 0, size);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }
}