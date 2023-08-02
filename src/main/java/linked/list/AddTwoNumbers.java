package src.main.java.linked.list;

public class AddTwoNumbers {

    ListNode res = null;

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(), new ListNode());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbers(l1, l2, 0);
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        if (null == l1 && null == l2) {
            if (carry > 0) {
                addNode(carry);
            }
            return res;
        }

        if (null != l1 && null != l2) {
            sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
        } else if (null != l1 && null == l2) {
            sum = l1.val + carry;
            l1 = l1.next;
        } else if (null == l1 && null != l2) {
            sum = l2.val + carry;
            l2 = l2.next;
        }

        carry = sum / 10;
        int val = sum >= 10 ? sum % 10 : sum;
        addNode(val);
        return addNumbers(l1, l2, carry);
    }

    public void addNode(int val) {
        if (res == null) {
            res = new ListNode(val);
        } else {
            ListNode last = res;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new ListNode(val);
        }
    }

}
