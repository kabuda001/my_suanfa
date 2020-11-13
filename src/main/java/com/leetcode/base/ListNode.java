package com.leetcode.base;

/**
 * ListNode
 *
 * @author zhaoc
 * @date 13 9:54 上午
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
