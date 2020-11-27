package com.leetcode.editor.cn;
//剑指 Offer 30:包含min函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 67 👎 0

import java.util.LinkedList;
import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min_stack.isEmpty()) {
                min_stack.push(x);
                return;
            }
            Integer oldMin = min_stack.peek();
            if (x < oldMin) {
                min_stack.push(x);
            } else {
                min_stack.push(oldMin);
            }
        }

        public void pop() {
            stack.pop();
            min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min_stack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        //测试代码
    }
}