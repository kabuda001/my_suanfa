package com.leetcode.editor.cn;
//738:单调递增的数字
//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 92 👎 0

public class MonotoneIncreasingDigits {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            String s = String.valueOf(N);
            int length = s.length();
            char[] chars = s.toCharArray();
            int flag = length;
            for (int i = length - 1; i >= 1; i--) {
                if (chars[i] < chars[i - 1]) {
                    flag = i;
                    chars[i - 1]--;
                }
            }

            for (int i = flag; i < length; i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new MonotoneIncreasingDigits().new Solution();
    }
}