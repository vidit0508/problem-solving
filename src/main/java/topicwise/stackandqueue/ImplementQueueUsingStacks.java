package src.main.java.topicwise.stackandqueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stackOne = null;
    Stack<Integer> stackTwo = null;

    public ImplementQueueUsingStacks() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void push(int x) {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        stackOne.push(x);
        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
    }

    public int pop() {
        return stackOne.pop();
    }

    public int peek() {
        return stackOne.peek();
    }

    public boolean empty() {
        return stackOne.isEmpty();
    }
}
