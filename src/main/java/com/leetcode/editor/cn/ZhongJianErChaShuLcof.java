package com.leetcode.editor.cn;
//剑指 Offer 07:重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 247 👎 0

import com.leetcode.base.TreeNode;

import java.util.Arrays;

public class ZhongJianErChaShuLcof {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            //左孩子的个数
            int leftCount = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    leftCount = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(preorder[0]);
            root.left = this.buildTree(Arrays.copyOfRange(preorder, 1, leftCount + 1), Arrays.copyOfRange(inorder, 0, leftCount));
            root.right = this.buildTree(Arrays.copyOfRange(preorder, leftCount + 1, preorder.length), Arrays.copyOfRange(inorder, leftCount + 1, inorder.length));
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }
}