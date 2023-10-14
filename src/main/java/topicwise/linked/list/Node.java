package src.main.java.topicwise.linked.list;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;

    public int key;
    public Node prev;

    public Node next;
    public Node child;

    public Node random;

    public List<Node> neighbors;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public Node() {

    }
};