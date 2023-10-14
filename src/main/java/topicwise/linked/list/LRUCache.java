package src.main.java.topicwise.linked.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map = null;
    private Node head;
    private Node tail;
    int capacity;
    int count;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 0);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        count = 0;
        map = new HashMap<>();
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }


    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            res = node.val;
            deleteNode(node);
            addToHead(node);
        }
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (count < capacity) {
                count++;
                addToHead(newNode);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(newNode);
            }
        }
    }
}
