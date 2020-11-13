package com.leetcode.editor.cn;
//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 290 👎 0

import com.leetcode.base.ListNode;

public class P328OddEvenLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null||head.next == null) {
                return head;
            }
            ListNode oddCur = head;
            ListNode evenFirst = head.next;
            ListNode evenCur = head.next;
            while (evenCur != null) {
                // 奇数的下一个
                ListNode oddNext = evenCur.next;
                if (oddNext == null) {
                    // 奇数已经为空,奇偶相连，然后返回
                    oddCur.next = evenFirst;
                    break;
                }
                // 奇数后续
                oddCur.next = oddNext;
                oddCur = oddCur.next;
                // 偶数的下一个
                ListNode evenNext = evenCur.next.next;
                evenCur.next = evenNext;
                evenCur = evenCur.next;
            }
            if (evenCur == null) {
                oddCur.next = evenFirst;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P328OddEvenLinkedList().new Solution();
    }
}