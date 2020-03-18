package BST;

import java.util.LinkedList;
import java.util.List;

/**
 * Question 230: Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */
public class KthSmallest {
    List<Integer> result = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return result.get(k-1);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}


