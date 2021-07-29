package com.leetcode.editor.cn;
//1104:二叉树寻路
//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 93 👎 0

import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            LinkedList<Integer> res = new LinkedList<>();
            // 获取层数
            int floor = this.pow(label);
            // 计算出最后一层左边的数
            int left = floor % 2 == 0 ? (1 << floor) - 1 : (1 << (floor - 1));
            // 计算出label的位置
            int index = floor % 2 == 0 ? left - label : label - left;
            // 循环计算
            while (floor > 1) {
                res.addFirst(left + (floor % 2 == 0 ? -index : index));
                floor--;
                index = index >> 1;
                left = floor % 2 == 0 ? (1 << floor) - 1 : (1 << (floor - 1));
            }
            res.addFirst(1);
            return res;
        }

        public int pow(int label) {
            int count = 0;
            while (label > 0) {
                count++;
                label /= 2;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
    }
}