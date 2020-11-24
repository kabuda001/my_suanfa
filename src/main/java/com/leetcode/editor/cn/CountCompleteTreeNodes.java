package com.leetcode.editor.cn;
//222:完全二叉树的节点个数
//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 302 👎 0

import com.leetcode.base.TreeNode;

import java.util.LinkedList;

public class CountCompleteTreeNodes {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ld = this.getDepth(root.left);
            int rd = this.getDepth(root.right);
            if (ld == rd) {
                // 左孩子一定是满二叉树,根节点+左子树的所有节点+右孩子的节点数
                return (1 << ld) + this.countNodes(root.right);
            } else {
                // 右孩子一定是满二叉树,根节点+右子树的所有节点+左孩子的节点数
                return (1 << rd) + this.countNodes(root.left);
            }
        }

        /**
         * 获取完全二叉树的深度
         */
        private int getDepth(TreeNode t) {
            int depth = 0;
            while (t != null) {
                depth++;
                t = t.left;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new CountCompleteTreeNodes().new Solution();
    }
}