package src.main.java.top.onefifty.medium.linked.list;

import src.main.java.topicwise.linked.list.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        for (int i = 1; i < left; i++) {
            before = before.next;
        }
        reverse(before, left, right);

        return dummy.next;
    }

    private ListNode reverse(ListNode before, int left, int right) {

        if (right - left == 0) {
            return before.next;
        }

        ListNode first, revSubListStart, revSubListEnd, last, after;
        first = before.next;

        if (right - left > 1) {
            revSubListEnd = reverse(first, left + 1, right - 1);
            revSubListStart = first.next;
            last = revSubListEnd.next;
        } else {
            last = first.next;
            revSubListStart = first;
            revSubListEnd = last;
        }

        after = last.next;
        before.next = last;
        last.next = revSubListStart;
        revSubListEnd.next = first;
        first.next = after;

        return first;

    }

}
