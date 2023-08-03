package src.main.java.linked.list;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode()));
    }

    public static boolean isPalindrome(ListNode head) {

        boolean res = true;

        // get the middle
        ListNode node = head;
        ListNode firstHalf = getMiddleNode(node);

        // reverse the part which is next from middle
        ListNode secondHalf = reverse(firstHalf.next);

        // iterate through start of head till end of reversed list
        while (secondHalf != null) {
            if (secondHalf.val != head.val) {
                res = false;
                break;
            }
            secondHalf = secondHalf.next;
            head = head.next;
        }

        return res;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode getMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
