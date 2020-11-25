package com.leetcode.editor.cn;
//剑指 Offer 17:打印从1到最大的n位数
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 65 👎 0

public class DaYinCong1daoZuiDaDeNweiShuLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int max = 9;
            for (int i = 1; i < n; i++) {
                max = max * 10 + 9;
            }
            int[] res = new int[max];
            for (int i = 0; i < max; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
    }
}