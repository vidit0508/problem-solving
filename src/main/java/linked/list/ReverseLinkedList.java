package src.main.java.linked.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        reverseList(new ListNode());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
