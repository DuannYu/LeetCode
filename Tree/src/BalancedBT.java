/**
 * Question 110: Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int leftDepth = depth(root.left) + 1;
        int rightDepth = depth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }
}
