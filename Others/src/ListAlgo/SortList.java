package ListAlgo;

/**
 * Question: Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode end = head;

        while (end.next != null) {
            end = end.next;
        }

        return quickSort(head, end);

    }

    private ListNode quickSort(ListNode left, ListNode right) {
        if (left == null || right == null || left == right)
            return left;

        ListNode first = left;
        ListNode second = left.next;

        int midValue = first.val;
        while (second != null && second != right.next) {
            if (second.val < midValue) {
                first = first.next;
                if (first != second) {
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
            }

            second = second.next;
        }

        if (left != first) {
            int temp = left.val;
            left.val = first.val;
            first.val = temp;
        }

        quickSort(left, first);
        quickSort(first.next, right);

        return left;
    }

    private void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;

        int left = leftIndex;
        int right = rightIndex;

        // 待排序的第一个元素作为基准值
        int key = nums[left];

        // 从左到右两边交替扫面
        while (left < right) {
            while (right > left && nums[right] > key) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= key) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = key;

        quickSort(nums, leftIndex, left-1);
        quickSort(nums, right+1, rightIndex);
    }
}
