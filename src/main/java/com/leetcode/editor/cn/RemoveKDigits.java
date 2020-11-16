package com.leetcode.editor.cn;
//402:移掉K位数字
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 411 👎 0

public class RemoveKDigits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) {
                return "0";
            }
            StringBuilder s = new StringBuilder(num);
            for (int i = 0; i < k; i++) {
                int idx = 0;
                for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                    idx = j;
                }
                s.delete(idx, idx + 1);
                while (s.length() > 1 && s.charAt(0) == '0') {
                    s.delete(0, 1);
                }
            }
            return s.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveKDigits().new Solution();
    }
}