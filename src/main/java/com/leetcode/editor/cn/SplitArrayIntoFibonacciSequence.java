package com.leetcode.editor.cn;
//842:将数组拆分成斐波那契序列
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 99 👎 0

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> splitIntoFibonacci(String S) {
            if (S == null || S.length() < 3) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            dfs(S, 0, res);
            return res;
        }

        private boolean dfs(String S, int p, List<Integer> res) {
            if (res.size() > 2 && p == S.length()) {
                return true;
            }
            for (int i = p; i < S.length(); i++) {
                if (i - p > 10) {
                    break;
                }
                String str = S.substring(p, i + 1);
                if (str.startsWith("0") && !str.equals("0")) {
                    break;
                }
                long num = Long.parseLong(str);
                if (num > Integer.MAX_VALUE) {
                    break;
                }
                Integer n = (int) num;
                if (res.size() < 2 || res.get(res.size() - 1) + res.get(res.size() - 2) == n) {
                    res.add(n);
                    if (dfs(S, i + 1, res)) {
                        return true;
                    } else {
                        res.remove(res.size() - 1);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new SplitArrayIntoFibonacciSequence().new Solution();
    }
}