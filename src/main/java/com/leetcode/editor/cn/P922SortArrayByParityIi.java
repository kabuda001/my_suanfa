package com.leetcode.editor.cn;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 146 👎 0

public class P922SortArrayByParityIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int aIndex = 0;
            int bIndex = 1;
            // 是否为偶数
            boolean isOdd;
            // 是否为奇数
            boolean isEven;
            while (aIndex <= A.length - 1) {
                isOdd = (A[aIndex] % 2 == 0);
                if (isOdd) {
                    aIndex += 2;
                    continue;
                }
                int tmp = A[aIndex];
                while (bIndex <= A.length - 1) {
                    isEven = (A[bIndex] % 2 != 0);
                    if (isEven) {
                        bIndex += 2;
                        continue;
                    }
                    A[aIndex] = A[bIndex];
                    A[bIndex] = tmp;
                    break;
                }
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P922SortArrayByParityIi().new Solution();
    }
}