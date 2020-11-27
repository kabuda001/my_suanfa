package com.leetcode.editor.cn;
//剑指 Offer 33:二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 146 👎 0

import com.leetcode.base.TreeNode;

import java.util.Arrays;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return this.recur(postorder, 0, postorder.length - 1);
        }

        private boolean recur(int[] postOrder, int i, int j) {
            if (i >= j) {
                // 已经找完了
                return true;
            }
            int m = i; // 第一个大于根节点的节点
            while (postOrder[m] < postOrder[j]) {
                m++;
            }
            int p = m;
            while (postOrder[p] > postOrder[j]) {
                p++;
            }
            // 根节点是对的，且左孩子和有孩子都是对的
            return p == j && this.recur(postOrder, i, m - 1) && this.recur(postOrder, m, j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }
}