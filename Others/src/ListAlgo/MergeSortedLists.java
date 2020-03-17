package ListAlgo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Question 23: Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;

        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                queue.add(node);
        }

        ListNode head = new ListNode(-1), cur = head;

        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;

            if (temp.next != null)
                queue.add(temp.next);
        }

        return head.next;
    }
}
