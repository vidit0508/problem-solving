package src.main.java.topicwise.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStackUsingQueues {

    Queue<Integer> queueOne = null;
    Queue<Integer> queueTwo = null;

    public MyStackUsingQueues() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
    }

    public void push(int x) {
        List<Integer> list = new ArrayList<>();

        while (!queueOne.isEmpty()) {
            queueTwo.add(queueOne.poll());
        }
        queueOne.add(x);
        while (!queueTwo.isEmpty()) {
            queueOne.add(queueTwo.poll());
        }
    }

    public int pop() {
        return queueOne.poll();
    }

    public int top() {
        return queueOne.peek();
    }

    public boolean empty() {
        return queueOne.isEmpty();
    }

}
