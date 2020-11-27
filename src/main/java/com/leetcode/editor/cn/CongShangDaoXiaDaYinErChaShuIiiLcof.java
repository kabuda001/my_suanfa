package com.leetcode.editor.cn;
//剑指 Offer 32 - III:从上到下打印二叉树 III
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
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
// 👍 56 👎 0

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                LinkedList<Integer> tmp = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) {
                        tmp.addLast(node.val);
                    } else {
                        tmp.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
}