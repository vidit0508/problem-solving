package src.main.java.topicwise.linked.list;

public class FlattenAMultilevelDoublyLinkedList {
    Node res = null;
    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        makeFlattenedList(head);
        return res;
    }

    public void makeFlattenedList(Node head) {
        while (head != null) {
            addNode(head);
            if (head.child != null) {
                makeFlattenedList(head.child);
            }
            head = head.next;
        }
    }

    public void addNode(Node node) {
        Node newNode = new Node();
        newNode.val = node.val;
        if (res == null) {
            res = newNode;
        } else {
            Node last = res;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }

    }
}
