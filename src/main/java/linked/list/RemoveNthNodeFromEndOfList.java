package src.main.java.linked.list;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(), 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // this case will check, when node to is first node from start
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
