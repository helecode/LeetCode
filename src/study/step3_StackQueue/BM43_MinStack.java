package study.step3_StackQueue;

import java.util.Stack;

public class BM43_MinStack {
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int minValue = minStack.pop();
            if (node < minValue) {
                minStack.push(node);
            } else {
                minStack.push(minValue);
            }
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            int value = dataStack.pop();
            int minValue = minStack.peek();
            if (value == minValue) {
                minStack.pop();
            }
        }

    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
