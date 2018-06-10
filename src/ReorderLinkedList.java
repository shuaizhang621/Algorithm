import myClass.ListNode;

public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // break to two chain
        ListNode newHead = slow.next;
        slow.next = null;

        //reverse
        newHead = reverse(newHead);

        //merge
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode one = head;
        ListNode two = newHead;
        while (one != null || two != null) {
            if (one != null) {
                cur.next = one;
                cur = cur.next;
                one = one.next;
            }
            if (two != null) {
                cur.next = two;
                cur = cur.next;
                two = two.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
