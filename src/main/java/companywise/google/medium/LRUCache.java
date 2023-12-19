package src.main.java.companywise.google.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;
    Node tail;
    int capacity;
    int count;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.prev = null;
        tail.next = null;

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;

        map = new HashMap<>();
    }

    public void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            res = temp.value;
            deleteNode(temp);
            addNodeToHead(temp);
        }
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            deleteNode(temp);
            addNodeToHead(temp);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (count < capacity) {
                count++;
                addNodeToHead(newNode);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNodeToHead(newNode);
            }
        }
    }
}

class Node {

    Node next;
    Node prev;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
