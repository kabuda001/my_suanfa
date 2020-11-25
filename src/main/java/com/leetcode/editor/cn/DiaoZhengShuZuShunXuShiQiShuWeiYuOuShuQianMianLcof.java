package com.leetcode.editor.cn;
//剑指 Offer 21:调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 62 👎 0

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            if (nums == null) {
                return nums;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                while (start < nums.length && nums[start] % 2 == 1) {
                    start++;
                }
                while (end >= 0 && nums[end] % 2 == 0) {
                    end--;
                }
                if (start >= end) {
                    continue;
                }
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
}