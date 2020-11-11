package com.leetcode.editor.cn;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 750 👎 0

import java.util.Arrays;

public class P31NextPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 1) {
                return;
            }
            int i = nums.length - 1;
            while (i > 0) {
                // 从后向前找
                if (nums[i] > nums[i - 1]) {
                    // 后一位大于前一位
                    int min = nums[i];
                    int k = i;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] < min && nums[j] > nums[i - 1]) {
                            //找寻大于前一位的最小数
                            k = j;
                            min = nums[j];
                        }

                    }
                    // 交换
                    int tmp = nums[i - 1];
                    nums[i - 1] = nums[k];
                    nums[k] = tmp;
                    Arrays.sort(nums, i, nums.length);
                    break;
                }
                i--;
            }
            if (i == 0) {
                //没有更大的数，直接排序
                Arrays.sort(nums);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P31NextPermutation().new Solution();
    }
}