package com.leetcode.editor.cn;
//118:杨辉三角
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 415 👎 0

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> pre = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        tmp.add(1);
                        continue;
                    }
                    if (j == i - 1) {
                        tmp.add(1);
                        continue;
                    }
                    int a = pre.get(j - 1) + pre.get(j);
                    tmp.add(a);
                }
                pre = tmp;
                res.add(pre);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new PascalsTriangle().new Solution();
    }
}