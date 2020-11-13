package com.leetcode.editor.cn;
//剑指 Offer 06:从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 71 👎 0

import com.leetcode.base.ListNode;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode tmp = head;
            if (tmp == null) {
                return new int[0];
            }
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.next;
            }
            int[] res = new int[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                res[index] = stack.pop().val;
                index++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
}