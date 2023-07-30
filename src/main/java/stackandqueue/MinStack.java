package src.main.java.stackandqueue;

import java.util.Stack;

public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        if (minStack.pop() == min) {
            min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
