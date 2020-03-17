package ListAlgo;

/**
 * Quesiont 147: Insertion Sort List
 *
 * Sort a linked list using insertion sort.
 */

public class InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode prev = temp;
        ListNode curr = head;

        while (curr != null) {
            prev = temp;
            // 从伪头部开始，让prev指向小于curr.val的最大结点
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return temp.next;
    }
}
