package ListAlgo;

/**
 * Question 24: Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null && head.next == null)
            return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;

        while (head != null && head.next != null && head.next.next != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = tmp1.next;

            tmp1.next = tmp2.next;
            tmp2.next = tmp1;

            head.next = tmp2;
            head = tmp1;
        }
        return temp.next;

    }

//    public ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        ListNode next = null;
//
//        while (curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
}
