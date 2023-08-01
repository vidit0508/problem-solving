package src.main.java.linked.list;

public class MergeTwoSortedLists {

    static ListNode node = null;

    public static void main(String[] args) {
        mergeTwoLists(new ListNode(), new ListNode());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) {
            return node;
        }

        if (null != list1 && null == list2) {
            return list1;
        }

        if (null == list1 && null != list2) {
            return list2;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                addNode(list1.val);
                list1 = list1.next;
            } else {
                addNode(list2.val);
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            addNode(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            addNode(list2.val);
            list2 = list2.next;
        }

        return node;
    }

    public static void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if (node != null) {
            ListNode last = node;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        } else {
            node = newNode;
        }
    }
}
