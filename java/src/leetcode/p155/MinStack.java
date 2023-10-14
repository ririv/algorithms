package leetcode.p155;

import java.util.Deque;
import java.util.LinkedList;

// 辅助栈
// 不用辅助栈的方法，记录差值
class MinStack {
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
