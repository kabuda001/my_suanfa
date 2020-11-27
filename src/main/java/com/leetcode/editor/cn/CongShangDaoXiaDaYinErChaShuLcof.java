package com.leetcode.editor.cn;
//剑指 Offer 32 - I:从上到下打印二叉树
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 51 👎 0

import com.leetcode.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class CongShangDaoXiaDaYinErChaShuLcof {
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

        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int[] tmp = new int[2000];
            int index = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                tmp[index] = cur.val;
                index++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return Arrays.copyOf(tmp, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
    }
}