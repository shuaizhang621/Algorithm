import myClass.ListNode;

public class ReverseLinkedList {
    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // l1 -> l2 -> l3
    //
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }
        return prev;
    }
}
