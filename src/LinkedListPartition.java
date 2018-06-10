import myClass.ListNode;

public class LinkedListPartition {
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);

        ListNode small = smallHead;
        ListNode large = largeHead;

        while (head != null) {
            if (head.value < target) {
                small.next = head;
                head = head.next;
                small = small.next;
                small.next = null; // break chain, prevent loop
            } else {
                large.next = head;
                head = head.next;
                large = large.next;
                large.next = null;
            }
        }

        small.next = largeHead.next;

        return smallHead.next;
    }
}
