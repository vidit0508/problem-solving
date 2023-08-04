package src.main.java.linked.list;

class Node {
    public int val;

    public int key;
    public Node prev;

    public Node next;
    public Node child;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {

    }
};