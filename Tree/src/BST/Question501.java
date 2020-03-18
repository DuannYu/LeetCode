package BST;

import java.util.LinkedList;
import java.util.List;

/**
 * Question 501: Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates, find all the mode(s)
 * (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */

public class Question501 {
    private int maxCount = 0;
    private int currentValue = 0;
    private int currentCount = 0;

    List<Integer> result = new LinkedList<>();
    List<Integer> ans = new LinkedList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(i);
        }
        return array;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        visit(root.val);
        inorder(root.right);
    }

    private void visit(int val) {
        if (currentCount > 0 && currentValue == val) {
            currentCount++;
        }
        else {
            currentValue = val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            ans.clear();
        }

        if (currentCount == maxCount) {
            ans.add(val);
        }
    }
}