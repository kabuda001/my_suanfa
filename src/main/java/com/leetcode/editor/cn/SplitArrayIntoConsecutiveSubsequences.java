package com.leetcode.editor.cn;
//659:分割数组为连续子序列
//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
//
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 149 👎 0

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            Map<Integer, Integer> lastCount = new HashMap<>();
            for (int num : nums) {
                countMap.merge(num, 1, Integer::sum);
            }
            for (int num : nums) {
                if (countMap.getOrDefault(num, 0) == 0) {
                    continue;
                }
                countMap.merge(num, -1, Integer::sum);
                if (lastCount.getOrDefault(num - 1, 0) > 0) {
                    // 上一个数字是连续的
                    lastCount.merge(num - 1, -1, Integer::sum);
                    lastCount.merge(num, 1, Integer::sum);
                } else if (countMap.getOrDefault(num + 1, 0) > 0 && countMap.getOrDefault(num + 2, 0) > 0) {
                    // 三个匹配成一个新的字符串出来
                    countMap.merge(num + 1, -1, Integer::sum);
                    countMap.merge(num + 2, -1, Integer::sum);
                    lastCount.merge(num + 2, 1, Integer::sum);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
    }
}