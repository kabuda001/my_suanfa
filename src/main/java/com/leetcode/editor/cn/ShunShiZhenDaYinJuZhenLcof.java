package com.leetcode.editor.cn;
//剑指 Offer 29:顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 156 👎 0

public class ShunShiZhenDaYinJuZhenLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }

            int n = matrix.length;
            int m = matrix[0].length;
            int nStart = 0;
            int mStart = 0;
            int nEnd = n - 1;
            int mEnd = m - 1;
            int[] res = new int[n * m];
            int cur = 0;
            while (nEnd >= nStart && mEnd >= mStart) {
                for (int i = mStart; i <= mEnd; i++) {
                    res[cur] = matrix[nStart][i];
                    cur++;
                }
                nStart++;
                for (int i = nStart; i <= nEnd; i++) {
                    res[cur] = matrix[i][mEnd];
                    cur++;
                }
                mEnd--;
                for (int i = mEnd; i >= mStart && nEnd >= nStart; i--) {
                    res[cur] = matrix[nEnd][i];
                    cur++;
                }
                nEnd--;
                for (int i = nEnd; i >= nStart && mEnd >= mStart; i--) {
                    res[cur] = matrix[i][mStart];
                    cur++;
                }
                mStart++;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }
}